package com.smarthome.air.conditioner.service.mappers

import com.smarthome.air.conditioner.service.entities.State
import com.smarthome.air.conditioner.service.model.AirConditionerStateDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StateMapper {
    fun toEntity(dto: AirConditionerStateDto): State
    fun toDto(entity: State): AirConditionerStateDto
}