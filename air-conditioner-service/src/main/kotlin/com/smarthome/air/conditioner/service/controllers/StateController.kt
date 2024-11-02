package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerStateApi
import com.smarthome.air.conditioner.service.model.AirConditionerStateDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping
class StateController(

) : AirConditionerStateApi {
    override fun createAirConditionerState(airConditionerStateDto: AirConditionerStateDto): ResponseEntity<AirConditionerStateDto> {
        TODO("Not yet implemented")
    }

    override fun getAirConditionerState(airConditionerId: String): ResponseEntity<AirConditionerStateDto> {
        TODO("Not yet implemented")
    }

    override fun updateAirConditionerState(
        airConditionerId: String,
        airConditionerStateDto: AirConditionerStateDto
    ): ResponseEntity<AirConditionerStateDto> {
        TODO("Not yet implemented")
    }
}