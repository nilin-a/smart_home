package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerTimerApi
import com.smarthome.air.conditioner.service.model.AirConditionerTimerDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping
class TimerController(

) : AirConditionerTimerApi {

    override fun createAirConditionerTimer(airConditionerTimerDto: AirConditionerTimerDto): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }

    override fun deleteAirConditionerTimer(airConditionerId: UUID): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getAirConditionerTimer(airConditionerId: UUID): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }

    override fun updateAirConditionerTimer(
        airConditionerId: UUID,
        airConditionerTimerDto: AirConditionerTimerDto
    ): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }
}