package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.GetAllAirConditionersByUserIdApi
import com.smarthome.air.conditioner.service.model.AirConditionerInformationDto
import org.springframework.http.ResponseEntity

class GetAllAirConditionersByUserId(

) : GetAllAirConditionersByUserIdApi {
    override fun getAirConditioners(): ResponseEntity<List<AirConditionerInformationDto>> {
        TODO("Not yet implemented")
    }
}