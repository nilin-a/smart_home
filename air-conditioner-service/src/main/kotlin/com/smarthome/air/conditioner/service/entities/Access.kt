package com.smarthome.air.conditioner.service.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "air_conditioner_access")
data class Access(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "air_conditioner_id", nullable = false)
    val info: Info,

    @Column(name = "user_id", nullable = false)
    val userId: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "access_type", nullable = false)
    val accessType: AccessType
) {
    enum class AccessType { OWNER, GUEST }
}
