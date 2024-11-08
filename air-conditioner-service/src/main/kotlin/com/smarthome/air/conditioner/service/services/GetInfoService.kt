package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.model.AirConditionerInformationDto
import com.smarthome.air.conditioner.service.repositories.AccessRepository
import com.smarthome.air.conditioner.service.repositories.AirConditionerInformationRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetInfoService(
    private val airConditionerInformationRepository: AirConditionerInformationRepository,
    private val accessRepository: AccessRepository,
) {

    fun getAllAirConditionersByUserId(userId: UUID): List<AirConditionerInformationDto> {
        return accessRepository.findAllByUserId(userId).map { it.airConditionerInformation }
    }
}