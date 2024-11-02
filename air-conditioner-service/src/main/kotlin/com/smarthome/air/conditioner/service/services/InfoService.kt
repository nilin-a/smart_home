package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.exceptions.NotFoundException
import com.smarthome.air.conditioner.service.mappers.InfoMapper
import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.repositories.InfoRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class InfoService(
    private val infoRepository: InfoRepository,
    private val infoMapper: InfoMapper
) {

    fun createAirConditionerInfo(info: AirConditionerInfoDto) = infoMapper.toDto(
        infoRepository.save(infoMapper.toEntity(info))
    )

    fun getAirConditionerInfo(airConditionerId: UUID) = infoMapper.toDto(
        infoRepository.findById(airConditionerId).orElseThrow {
            throw NotFoundException.AirConditionerInfoNotFoundByIdException(
                "Информация о кондиционере не найдена на id = $airConditionerId")
        }
    )

    fun updateAirConditionerInfo(airConditionerId: UUID, info: AirConditionerInfoDto): AirConditionerInfoDto {
        if (infoRepository.existsById(airConditionerId)) {
            return infoMapper.toDto(
                infoRepository.save(infoMapper.toEntity(info.copy(airConditionerId = airConditionerId)))
            )
        } else {
            throw NotFoundException.AirConditionerInfoNotFoundByIdException(
                "Кондиционере для обновления не найден по id = $airConditionerId")
        }
    }

    fun deleteAirConditionerInfo(airConditionerId: UUID) {
        infoRepository.deleteById(airConditionerId)
    }
}