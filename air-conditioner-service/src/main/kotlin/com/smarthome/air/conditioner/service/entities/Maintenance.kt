package com.smarthome.air.conditioner.service.entities

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "air_conditioner_maintenance_schedule")
data class Maintenance(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "air_conditioner_id", nullable = false)
    val info: Info,

    @Column(name = "next_maintenance_date", nullable = false)
    val nextMaintenanceDate: OffsetDateTime,

    @Column(name = "interval_days", nullable = false)
    val intervalDays: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "maintenance_status", nullable = false)
    val maintenanceStatus: MaintenanceStatus
) {
    enum class MaintenanceStatus { COMPLETED, POSTPONED, CANCELLED, SCHEDULED }
}
