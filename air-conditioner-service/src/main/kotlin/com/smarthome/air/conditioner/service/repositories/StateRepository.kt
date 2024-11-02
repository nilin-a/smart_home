package com.smarthome.air.conditioner.service.repositories

import com.smarthome.air.conditioner.service.entities.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StateRepository : JpaRepository<State, Long> {

}