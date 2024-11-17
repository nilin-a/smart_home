import sqlalchemy as sa
from sqlalchemy.orm import declarative_base
from sqlalchemy.dialects.postgresql import UUID
from sqlalchemy.types import Enum as SQLAEnum
import uuid
import enum

Base = declarative_base()


class StatusEnum(enum.Enum):
    ON = "ON"
    OFF = "OFF"


class ModeEnum(enum.Enum):
    BOIL = "Boil"
    TEMPERATURE_CONTROL = "Temperature Control"


class ElectricKettleInformation(Base):
    __tablename__ = "electric_kettle_info"

    electric_kettle_id = sa.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    name = sa.Column(sa.String, nullable=False)
    manufacturer = sa.Column(sa.String, nullable=False)
    model = sa.Column(sa.String, nullable=False)
    status = sa.Column(SQLAEnum(StatusEnum), nullable=False)
    mode = sa.Column(SQLAEnum(ModeEnum))
    temperature = sa.Column(sa.Integer)
    state_updated_at = sa.Column(sa.DateTime, nullable=False)


class Access(Base):
    __tablename__ = "user_access"

    id = sa.Column(sa.BigInteger, primary_key=True, autoincrement=True)
    user_id = sa.Column(UUID(as_uuid=True), nullable=False)
    kettle_id = sa.Column(UUID(as_uuid=True), sa.ForeignKey("kettles.id"), nullable=False)
