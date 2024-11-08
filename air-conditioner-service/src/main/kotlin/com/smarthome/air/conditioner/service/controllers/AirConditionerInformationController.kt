package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerInfoApi
import com.smarthome.air.conditioner.service.services.AirConditionerInformationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AirConditionerInformationController(
    private val airConditionerInformationService: AirConditionerInformationService
) {

    //TODO()
    /*override fun createAirConditionerInfo(airConditionerInfoDto: AirConditionerInfoDto) =
        ResponseEntity.ok(
            airConditionerInformationService.createAirConditionerInfo(airConditionerInfoDto)
        )

    override fun getAirConditionerInfo(airConditionerId: UUID) =
        ResponseEntity.ok(
            airConditionerInformationService.getAirConditionerInfo(airConditionerId)
        )

    override fun updateAirConditionerInfo(airConditionerId: UUID, airConditionerInfoDto: AirConditionerInfoDto) =
        ResponseEntity.ok(
            airConditionerInformationService.updateAirConditionerInfo(airConditionerId, airConditionerInfoDto)
        )

    override fun deleteAirConditionerInfo(airConditionerId: UUID) =
        ResponseEntity.ok(
            airConditionerInformationService.deleteAirConditionerInfo(airConditionerId)
        )

     */
}
