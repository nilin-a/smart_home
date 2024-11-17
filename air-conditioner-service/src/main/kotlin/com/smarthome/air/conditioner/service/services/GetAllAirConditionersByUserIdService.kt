package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.repositories.AirConditionerInformationRepository
import org.springframework.stereotype.Service

@Service
class GetAllAirConditionersByUserIdService(
    private val airConditionerInformationRepository: AirConditionerInformationRepository,
) {

    fun getAllAirConditioners(): List<AirConditionerInfoDto> {
        val result = airConditionerInformationRepository.findAll()
        return result.map { device -> AirConditionerInfoDto(
            airConditionerId = device.airConditionerId,
            name = device.name,
            manufacturer = device.manufacturer,
            model = device.model,
        ) }
    }
}