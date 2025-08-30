package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustVacuumEntity

data class ThrustVacuumDto(
    val kN: Long?,
    val lbf: Long?,
    val rocketId: Int?
)

fun ThrustVacuumDto.toThrustVacuumEntity(rocketId: Int?) = ThrustVacuumEntity(
    id = 0,
    kN = kN,
    lbf = lbf,
    rocketId = rocketId
)
