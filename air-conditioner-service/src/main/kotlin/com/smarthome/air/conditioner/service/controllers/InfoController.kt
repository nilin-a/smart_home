package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerInfoApi
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class InfoController(

) : AirConditionerInfoApi {

    override fun createAirConditionerInfo(airConditionerInfoDto: AirConditionerInfoDto): ResponseEntity<AirConditionerInfoDto> {
        TODO("Not yet implemented")
    }

    override fun deleteAirConditionerInfo(airConditionerId: String): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getAirConditionerInfo(airConditionerId: String): ResponseEntity<AirConditionerInfoDto> {
        TODO("Not yet implemented")
    }

    override fun updateAirConditionerInfo(
        airConditionerId: String,
        airConditionerInfoDto: AirConditionerInfoDto
    ): ResponseEntity<AirConditionerInfoDto> {
        TODO("Not yet implemented")
    }
}
