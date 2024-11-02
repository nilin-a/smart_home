package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerTimerApi
import com.smarthome.air.conditioner.service.model.AirConditionerTimerDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping
class TimerController(

) : AirConditionerTimerApi {

    override fun createAirConditionerTimer(airConditionerTimerDto: AirConditionerTimerDto): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }

    override fun deleteAirConditionerTimer(airConditionerId: String): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getAirConditionerTimer(airConditionerId: String): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }

    override fun updateAirConditionerTimer(
        airConditionerId: String,
        airConditionerTimerDto: AirConditionerTimerDto
    ): ResponseEntity<AirConditionerTimerDto> {
        TODO("Not yet implemented")
    }
}