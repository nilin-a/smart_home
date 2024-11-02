package com.smarthome.air.conditioner.service.repositories

import com.smarthome.air.conditioner.service.entities.Timer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TimerRepository : JpaRepository<Timer, Long> {
    fun findByInfoAirConditionerId(airConditionerId: UUID): List<Timer>
}