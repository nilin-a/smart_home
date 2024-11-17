package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.GetAllAirConditionersByUserIdApi
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.services.GetAllAirConditionersByUserIdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class GetAllAirConditionersByUserIdController(
    private val getAllAirConditionersByUserIdService: GetAllAirConditionersByUserIdService,
) : GetAllAirConditionersByUserIdApi {

    override fun getAirConditioners(): ResponseEntity<List<AirConditionerInfoDto>> {
        return ResponseEntity.ok(getAllAirConditionersByUserIdService.getAllAirConditioners())
    }
}