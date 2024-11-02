package com.smarthome.air.conditioner.service.services

import com.smarthome.air.conditioner.service.exceptions.NotFoundException
import com.smarthome.air.conditioner.service.mappers.TimerMapper
import com.smarthome.air.conditioner.service.model.AirConditionerTimerDto
import com.smarthome.air.conditioner.service.repositories.TimerRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TimerService(
    private val timerRepository: TimerRepository,
    private val timerMapper: TimerMapper
) {

    fun createAirConditionerTimer(timerDto: AirConditionerTimerDto) = timerMapper.toDto(
        timerRepository.save(timerMapper.toEntity(timerDto))
    )

    fun getAirConditionerTimer(airConditionerId: UUID): List<AirConditionerTimerDto> =
        timerRepository.findByInfoAirConditionerId(airConditionerId)
            .map(timerMapper::toDto)

    fun updateAirConditionerTimer(airConditionerId: UUID, timerDto: AirConditionerTimerDto): AirConditionerTimerDto {
        val existingTimer = timerRepository.findById(airConditionerId)
        if (existingTimer.isPresent && existingTimer.get().info.airConditionerId == airConditionerId) {
            return timerMapper.toDto(
                timerRepository.save(timerMapper.toEntity(timerDto.copy(airConditionerId = airConditionerId)))
            )
        } else {
            throw NotFoundException.TimerNotFoundException("Таймер не найден для кондиционера с id = $airConditionerId")
        }
    }

    fun deleteAirConditionerTimer(airConditionerId: UUID, timerId: Long) {
        if (timerRepository.existsById(timerId)) {
            timerRepository.deleteById(timerId)
        } else {
            throw NotFoundException.TimerNotFoundException("Таймер с id = $timerId не найден для удаления")
        }
    }
}