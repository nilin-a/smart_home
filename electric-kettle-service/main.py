from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.ext.asyncio import AsyncSession
from database import init_db, AsyncSessionLocal
from requests import (
    get_kettles_by_user_id,
    create_kettle,
    get_kettle_info,
    update_kettle_state,
    update_kettle_info,
    add_kettle_access,
    remove_kettle_access
)
from auth import get_current_user_id
from uuid import UUID
from models import KettleCreate, KettleStateUpdate, KettleInfoUpdate
from py_eureka_client.eureka_client import EurekaClient

app = FastAPI()

# Конфигурация Eureka клиента
eureka_client = EurekaClient(
    eureka_server="http://localhost:8761/eureka",
    app_name="electric-kettle-service",
    instance_port=8083,
    instance_ip="localhost",
    health_check_url="/health",
    instance_id="electric-kettle-service-1",
)


async def get_session() -> AsyncSession:
    async with AsyncSessionLocal() as session:
        yield session


@app.on_event("startup")
async def on_startup():
    await init_db()


@app.get("/electric_kettles")
async def read_kettles(
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    return await get_kettles_by_user_id(user_id, session)


@app.post("/electric_kettle")
async def create_new_kettle(
        kettle_data: KettleCreate,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    return await create_kettle(kettle_data, user_id, session)


@app.get("/electric_kettle/{electric_kettle_id}")
async def read_kettle_info(
        electric_kettle_id: UUID,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    try:
        return await get_kettle_info(electric_kettle_id, user_id, session)
    except PermissionError as e:
        raise HTTPException(status_code=403, detail=str(e))


@app.patch("/electric_kettle/state")
async def update_kettle_status(
        state_update: KettleStateUpdate,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    try:
        return await update_kettle_state(
            state_update.electric_kettle_id,
            user_id,
            session,
            state_update.status,
            state_update.mode,
            state_update.temperature
        )
    except PermissionError as e:
        raise HTTPException(status_code=403, detail=str(e))


@app.patch("/electric_kettle/info")
async def update_kettle_name(
        info_update: KettleInfoUpdate,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    try:
        return await update_kettle_info(info_update.electric_kettle_id, user_id, info_update.name, session)
    except PermissionError as e:
        raise HTTPException(status_code=403, detail=str(e))


@app.post("/electric_kettle/access/{electric_kettle_id}")
async def add_access(
        electric_kettle_id: UUID,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    try:
        return await add_kettle_access(electric_kettle_id, user_id, session)
    except ValueError as e:
        raise HTTPException(status_code=400, detail=str(e))


@app.delete("/electric_kettle/access/{electric_kettle_id}")
async def delete_access(
        electric_kettle_id: UUID,
        session: AsyncSession = Depends(get_session),
        user_id: UUID = Depends(get_current_user_id)
):
    try:
        await remove_kettle_access(electric_kettle_id, user_id, session)
        return {"detail": "Access removed successfully"}
    except PermissionError as e:
        raise HTTPException(status_code=403, detail=str(e))
