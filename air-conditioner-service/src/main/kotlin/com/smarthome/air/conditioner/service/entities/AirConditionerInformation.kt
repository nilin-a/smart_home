package com.smarthome.air.conditioner.service.entities

import java.util.UUID
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "air_conditioner_info")
data class AirConditionerInformation(

    @Id
    @Column(name = "air_conditioner_id")
    val airConditionerId: UUID = UUID.randomUUID(),

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "manufacturer", nullable = false)
    val manufacturer: String,

    @Column(name = "model", nullable = false)
    val model: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: Status,

    @Enumerated(EnumType.STRING)
    @Column(name = "mode")
    val mode: Mode? = null,

    @Column(name = "temperature")
    val temperature: Int? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "fan_speed")
    val fanSpeed: FanSpeed? = null,

    @Column(name = "state_updated_at", nullable = false)
    val stateUpdatedAt: OffsetDateTime,
) {
    enum class Mode { COOLING, HEATING }
    enum class FanSpeed { LOW, MEDIUM, HIGH }
    enum class Status { ON, OFF }
}
