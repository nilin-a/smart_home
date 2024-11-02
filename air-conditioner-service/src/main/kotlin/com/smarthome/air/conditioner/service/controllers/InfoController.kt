package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerInfoApi
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.services.InfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class InfoController(
    private val infoService: InfoService
) : AirConditionerInfoApi {

    override fun createAirConditionerInfo(airConditionerInfoDto: AirConditionerInfoDto) =
        ResponseEntity.ok(
            infoService.createAirConditionerInfo(airConditionerInfoDto)
        )

    override fun getAirConditionerInfo(airConditionerId: UUID) =
        ResponseEntity.ok(
            infoService.getAirConditionerInfo(airConditionerId)
        )

    override fun updateAirConditionerInfo(airConditionerId: UUID, airConditionerInfoDto: AirConditionerInfoDto) =
        ResponseEntity.ok(
            infoService.updateAirConditionerInfo(airConditionerId, airConditionerInfoDto)
        )

    override fun deleteAirConditionerInfo(airConditionerId: UUID) =
        ResponseEntity.ok(
            infoService.deleteAirConditionerInfo(airConditionerId)
        )
}
