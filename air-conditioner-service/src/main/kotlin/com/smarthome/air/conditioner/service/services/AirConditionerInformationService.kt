package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.model.AirConditionerInfoDto
import com.smarthome.air.conditioner.service.repositories.AirConditionerInformationRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AirConditionerInformationService(
    private val infoRepository: AirConditionerInformationRepository,
) {

    fun createAirConditionerInfo(info: AirConditionerInfoDto) : AirConditionerInfoDto  {
        TODO()
        /*
            = infoMapper.toDto(
        infoRepository.save(infoMapper.toEntity(info))
    )
         */
    }


    fun getAirConditionerInfo(airConditionerId: UUID) : AirConditionerInfoDto {
        TODO()
        /*
        = infoMapper.toDto(
        infoRepository.findById(airConditionerId).orElseThrow {
            throw NotFoundException.AirConditionerInfoNotFoundByIdException(
                "Информация о кондиционере не найдена на id = $airConditionerId")
        }
    )
         */
    }

    fun updateAirConditionerInfo(airConditionerId: UUID, info: AirConditionerInfoDto): AirConditionerInfoDto {
        /*if (infoRepository.existsById(airConditionerId)) {
            return infoMapper.toDto(
                infoRepository.save(infoMapper.toEntity(info.copy(airConditionerId = airConditionerId)))
            )
        } else {
            throw NotFoundException.AirConditionerInfoNotFoundByIdException(
                "Кондиционере для обновления не найден по id = $airConditionerId")
        }

         */
        TODO()
    }

    fun deleteAirConditionerInfo(airConditionerId: UUID) {
        infoRepository.deleteById(airConditionerId)
    }
}