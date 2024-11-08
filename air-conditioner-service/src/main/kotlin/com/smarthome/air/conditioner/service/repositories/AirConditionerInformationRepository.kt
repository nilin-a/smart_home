package com.smarthome.air.conditioner.service.repositories

import com.smarthome.air.conditioner.service.entities.AirConditionerInformation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AirConditionerInformationRepository : JpaRepository<AirConditionerInformation, UUID> {

}