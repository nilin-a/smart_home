package com.smarthome.air.conditioner.service.mappers

import com.smarthome.air.conditioner.service.entities.AirConditionerInformation
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface InfoMapper {
    fun toEntity(dto: AirConditionerInfoDto): AirConditionerInformation
    fun toDto(entity: AirConditionerInformation): AirConditionerInfoDto
}