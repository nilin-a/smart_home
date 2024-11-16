package com.smarthome.air.conditioner.service.repositories

import com.smarthome.air.conditioner.service.entities.Access
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccessRepository : JpaRepository<Access, Long> {
    fun findAllByUserId(userId: UUID): List<Access>

}