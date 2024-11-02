package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.mappers.StateMapper
import com.smarthome.air.conditioner.service.model.AirConditionerStateDto
import com.smarthome.air.conditioner.service.repositories.StateRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StateService(
    private val stateRepository: StateRepository,
    private val stateMapper: StateMapper
) {

    fun createAirConditionerState(stateDto: AirConditionerStateDto): AirConditionerStateDto {
        val state = stateMapper.toEntity(stateDto)
        return stateMapper.toDto(stateRepository.save(state))
    }

    //TODO по airConditionerId должно получаться состояние с самым свежим временем
    /*fun getAirConditionerState(airConditionerId: UUID): AirConditionerStateDto {
        val state = stateRepository.findById(airConditionerId).orElseThrow {
            throw NotFoundException.AirConditionerStateNotFoundByIdException(
                "Состояние кондиционера не найдено для id = $airConditionerId"
            )
        }
        return stateMapper.toDto(state)
    }

    fun updateAirConditionerState(airConditionerId: UUID, stateDto: AirConditionerStateDto): AirConditionerStateDto {
        if (stateRepository.existsById(airConditionerId)) {
            val state = stateMapper.toEntity(stateDto.copy(airConditionerId = airConditionerId))
            return stateMapper.toDto(stateRepository.save(state))
        } else {
            throw NotFoundException.AirConditionerStateNotFoundByIdException(
                "Кондиционер для обновления состояния не найден по id = $airConditionerId"
            )
        }
    }

     */
}