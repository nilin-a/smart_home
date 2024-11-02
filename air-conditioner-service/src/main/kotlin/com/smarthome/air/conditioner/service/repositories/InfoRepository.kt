package com.smarthome.air.conditioner.service.repositories

import com.smarthome.air.conditioner.service.entities.Info
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface InfoRepository : JpaRepository<Info, UUID> {

}