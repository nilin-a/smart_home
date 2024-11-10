from pydantic import BaseModel
from uuid import UUID
from entities import StatusEnum, ModeEnum


class KettleCreate(BaseModel):
    name: str
    manufacturer: str
    model: str


class KettleStateUpdate(BaseModel):
    electric_kettle_id: UUID
    status: StatusEnum
    mode: ModeEnum
    temperature: int


class KettleInfoUpdate(BaseModel):
    electric_kettle_id: UUID
    name: str
