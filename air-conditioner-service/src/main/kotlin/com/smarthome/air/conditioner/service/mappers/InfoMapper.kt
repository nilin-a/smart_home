package com.smarthome.air.conditioner.service.mappers

import com.smarthome.air.conditioner.service.entities.AirConditionerInformation
import com.smarthome.air.conditioner.service.model.AirConditionerInformationDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface InfoMapper {
    fun toEntity(dto: AirConditionerInformationDto): AirConditionerInformation
    fun toDto(entity: AirConditionerInformation): AirConditionerInformationDto
}