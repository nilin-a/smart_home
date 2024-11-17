package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.entities.AirConditionerInformation
import com.smarthome.air.conditioner.service.entities.AirConditionerInformation.*
import com.smarthome.air.conditioner.service.model.AirConditionerFullInfoDto
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.repositories.AirConditionerInformationRepository
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class AddAirConditionerService(
    private val airConditionerInformationRepository: AirConditionerInformationRepository,
) {

    fun addAirConditioner(airConditionerInfoDto: AirConditionerInfoDto) : AirConditionerFullInfoDto {
        val result = airConditionerInformationRepository.save(AirConditionerInformation(
            name = airConditionerInfoDto.name!!,
            manufacturer = airConditionerInfoDto.manufacturer!!,
            model = airConditionerInfoDto.model!!,
            status = Status.OFF,
            mode = null,
            temperature = null,
            fanSpeed = null,
            stateUpdatedAt = OffsetDateTime.now(),
        ))
        return AirConditionerFullInfoDto(
            airConditionerId = result.airConditionerId,
            name = result.name,
            manufacturer = result.manufacturer,
            model = result.model,
            status = AirConditionerFullInfoDto.Status.OFF,
            mode = null,
            temperature = null,
            fanSpeed = null,
            stateUpdatedAt = result.stateUpdatedAt,
        )
    }
}