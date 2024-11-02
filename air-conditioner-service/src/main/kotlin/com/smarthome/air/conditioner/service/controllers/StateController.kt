package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerStateApi
import com.smarthome.air.conditioner.service.model.AirConditionerStateDto
import com.smarthome.air.conditioner.service.services.StateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping
class StateController(
    private val stateService: StateService,
) : AirConditionerStateApi {

    override fun createAirConditionerState(airConditionerStateDto: AirConditionerStateDto) =
        ResponseEntity.ok(
            stateService.createAirConditionerState(airConditionerStateDto)
        )

    override fun getAirConditionerState(airConditionerId: UUID) =
        ResponseEntity.ok(
            stateService.getAirConditionerState(airConditionerId)
        )

    override fun updateAirConditionerState(airConditionerId: UUID, airConditionerStateDto: AirConditionerStateDto) =
        ResponseEntity.ok(
            stateService.updateAirConditionerState(airConditionerId, airConditionerStateDto)
        )
}