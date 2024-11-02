package com.smarthome.air.conditioner.service.entities

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "air_conditioner_timer")
data class Timer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val timerId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "air_conditioner_id", nullable = false)
    val info: Info,

    @Column(name = "start_time", nullable = false)
    val startTime: OffsetDateTime,

    @Column(name = "stop_time")
    val stopTime: OffsetDateTime? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "recurrence")
    val recurrence: Recurrence? = null
) {
    enum class Recurrence { DAILY, WEEKLY }
}
