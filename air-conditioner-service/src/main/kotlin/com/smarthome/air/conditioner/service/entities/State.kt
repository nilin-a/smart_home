package com.smarthome.air.conditioner.service.entities

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "air_conditioner_state")
data class State(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val stateId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "air_conditioner_id", nullable = false)
    val info: Info,

    @Enumerated(EnumType.STRING)
    @Column(name = "mode", nullable = false)
    val mode: Mode,

    @Column(name = "temperature", nullable = false)
    val temperature: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "fan_speed", nullable = false)
    val fanSpeed: FanSpeed,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: Status,

    @Column(name = "state_updated_at", nullable = false)
    val stateUpdatedAt: OffsetDateTime
) {
    enum class Mode { COOLING, HEATING }
    enum class FanSpeed { LOW, MEDIUM, HIGH }
    enum class Status { ON, OFF, STAND_BY }
}
