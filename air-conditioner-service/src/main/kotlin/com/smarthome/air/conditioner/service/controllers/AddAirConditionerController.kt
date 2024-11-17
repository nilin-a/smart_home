package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AddAirConditionerApi
import com.smarthome.air.conditioner.service.model.AirConditionerFullInfoDto
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.services.AddAirConditionerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class AddAirConditionerController(
    private val addAirConditionerService: AddAirConditionerService,
) : AddAirConditionerApi {

    override fun addAirConditionerInfo(airConditionerInfoDto: AirConditionerInfoDto): ResponseEntity<AirConditionerFullInfoDto> {
        return ResponseEntity.ok(addAirConditionerService.addAirConditioner(airConditionerInfoDto))
    }
}