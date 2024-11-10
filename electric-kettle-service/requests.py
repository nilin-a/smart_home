from datetime import datetime
from typing import List
import uuid
from pytz import timezone
from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy.future import select
from sqlalchemy import update, delete
from entities import ElectricKettleInformation, Access, StatusEnum, ModeEnum


async def get_kettles_by_user_id(user_id: uuid.UUID, db: AsyncSession) -> List[ElectricKettleInformation]:
    query = (
        select(ElectricKettleInformation)
        .join(Access, ElectricKettleInformation.electric_kettle_id == Access.kettle_id)
        .where(Access.user_id == user_id)
    )
    result = await db.execute(query)
    return result.scalars().all()


async def create_kettle(name: str, manufacturer: str, model: str, user_id: uuid.UUID,
                        db: AsyncSession) -> ElectricKettleInformation:
    new_kettle = ElectricKettleInformation(
        electric_kettle_id=uuid.uuid4(),
        name=name,
        manufacturer=manufacturer,
        model=model,
        status=StatusEnum.OFF,
        mode=None,
        temperature=None,
        state_updated_at=datetime.now(timezone("Europe/Samara"))
    )

    db.add(new_kettle)
    await db.flush()

    user_access = Access(
        user_id=user_id,
        kettle_id=new_kettle.electric_kettle_id
    )

    db.add(user_access)
    await db.commit()

    return new_kettle


# Получение информации о чайнике по ID
async def get_kettle_info(electric_kettle_id: uuid.UUID, user_id: uuid.UUID,
                          db: AsyncSession) -> ElectricKettleInformation:
    # Проверка доступа
    access_check = (
        select(Access)
        .where(Access.user_id == user_id, Access.kettle_id == electric_kettle_id)
    )
    access_result = await db.execute(access_check)
    if not access_result.scalar():
        raise PermissionError("Access denied to the kettle.")

    # Получение информации о чайнике
    query = select(ElectricKettleInformation).where(ElectricKettleInformation.electric_kettle_id == electric_kettle_id)
    result = await db.execute(query)
    kettle_info = result.scalar_one_or_none()
    if kettle_info is None:
        raise ValueError("Kettle not found.")
    return kettle_info


# Изменение состояния чайника
async def update_kettle_state(electric_kettle_id: uuid.UUID, user_id: uuid.UUID, db: AsyncSession, status: StatusEnum,
                              mode: ModeEnum, temperature: int) -> ElectricKettleInformation:
    await check_user_access(user_id, electric_kettle_id, db)

    query = (
        update(ElectricKettleInformation)
        .where(ElectricKettleInformation.electric_kettle_id == electric_kettle_id)
        .values(
            status=status,
            mode=mode,
            temperature=temperature,
            state_updated_at=datetime.now(timezone("Europe/Samara"))
        )
        .returning(ElectricKettleInformation)
    )
    result = await db.execute(query)
    await db.commit()
    return result.scalar_one()


# Изменение информации о чайнике
async def update_kettle_info(electric_kettle_id: uuid.UUID, user_id: uuid.UUID, name: str,
                             db: AsyncSession) -> ElectricKettleInformation:
    await check_user_access(user_id, electric_kettle_id, db)

    query = (
        update(ElectricKettleInformation)
        .where(ElectricKettleInformation.electric_kettle_id == electric_kettle_id)
        .values(name=name)
        .returning(ElectricKettleInformation)
    )
    result = await db.execute(query)
    await db.commit()
    return result.scalar_one()


# Добавление доступа к чайнику
async def add_kettle_access(electric_kettle_id: uuid.UUID, user_id: uuid.UUID, db: AsyncSession) -> Access:
    # Проверка на существующий доступ
    existing_access = (
        select(Access)
        .where(Access.user_id == user_id, Access.kettle_id == electric_kettle_id)
    )
    result = await db.execute(existing_access)
    if result.scalar():
        raise ValueError("Access already exists.")

    # Добавление нового доступа
    new_access = Access(user_id=user_id, kettle_id=electric_kettle_id)
    db.add(new_access)
    await db.commit()
    return new_access


# Удаление доступа к чайнику
async def remove_kettle_access(electric_kettle_id: uuid.UUID, user_id: uuid.UUID, db: AsyncSession):
    await check_user_access(user_id, electric_kettle_id, db)

    delete_query = delete(Access).where(Access.user_id == user_id, Access.kettle_id == electric_kettle_id)
    await db.execute(delete_query)
    await db.commit()


# Проверка доступа пользователя к чайнику
async def check_user_access(user_id: uuid.UUID, kettle_id: uuid.UUID, db: AsyncSession):
    access_check = (
        select(Access)
        .where(Access.user_id == user_id, Access.kettle_id == kettle_id)
    )
    access_result = await db.execute(access_check)
    if not access_result.scalar():
        raise PermissionError("Access denied.")
