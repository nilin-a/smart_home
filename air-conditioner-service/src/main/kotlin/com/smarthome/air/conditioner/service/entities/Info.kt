package com.smarthome.air.conditioner.service.entities

import java.util.UUID
import jakarta.persistence.*

@Entity
@Table(name = "air_conditioner_info")
data class Info(

    @Id
    @Column(name = "air_conditioner_id")
    val airConditionerId: UUID = UUID.randomUUID(),

    @Column(name = "room_id")
    val roomId: UUID,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "serial_number", nullable = false)
    val serialNumber: String,

    @Column(name = "manufacturer", nullable = false)
    val manufacturer: String,

    @Column(name = "model", nullable = false)
    val model: String,

    @OneToMany(mappedBy = "airConditionerInfo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val states: List<State> = emptyList(),

    @OneToMany(mappedBy = "airConditionerInfo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val timers: List<Timer> = emptyList(),

    @OneToMany(mappedBy = "airConditionerInfo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val maintenanceSchedules: List<Maintenance> = emptyList(),

    @OneToMany(mappedBy = "airConditionerInfo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val accessList: List<Access> = emptyList()
)
