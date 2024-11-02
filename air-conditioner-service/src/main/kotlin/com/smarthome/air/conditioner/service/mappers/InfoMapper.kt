package com.smarthome.air.conditioner.service.mappers

import com.smarthome.air.conditioner.service.entities.Info
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface InfoMapper {
    fun toEntity(dto: AirConditionerInfoDto): Info
    fun toDto(entity: Info): AirConditionerInfoDto
}