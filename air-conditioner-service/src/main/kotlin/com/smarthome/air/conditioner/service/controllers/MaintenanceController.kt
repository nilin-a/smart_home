package com.smarthome.air.conditioner.service.controllers

import com.smarthome.air.conditioner.service.api.AirConditionerMaintenanceApi
import com.smarthome.air.conditioner.service.model.AirConditionerMaintenanceScheduleDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping
class MaintenanceController(

) : AirConditionerMaintenanceApi {

    override fun createAirConditionerMaintenance(airConditionerMaintenanceScheduleDto: AirConditionerMaintenanceScheduleDto): ResponseEntity<AirConditionerMaintenanceScheduleDto> {
        TODO("Not yet implemented")
    }

    override fun deleteAirConditionerMaintenance(airConditionerId: String): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getAirConditionerMaintenance(airConditionerId: String): ResponseEntity<AirConditionerMaintenanceScheduleDto> {
        TODO("Not yet implemented")
    }

    override fun updateAirConditionerMaintenance(
        airConditionerId: String,
        airConditionerMaintenanceScheduleDto: AirConditionerMaintenanceScheduleDto
    ): ResponseEntity<AirConditionerMaintenanceScheduleDto> {
        TODO("Not yet implemented")
    }
}