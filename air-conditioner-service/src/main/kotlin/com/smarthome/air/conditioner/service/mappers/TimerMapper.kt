package com.smarthome.air.conditioner.service.mappers

import com.smarthome.air.conditioner.service.entities.Timer
import com.smarthome.air.conditioner.service.model.AirConditionerTimerDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TimerMapper {
    fun toEntity(dto: AirConditionerTimerDto): Timer
    fun toDto(entity: Timer): AirConditionerTimerDto
}