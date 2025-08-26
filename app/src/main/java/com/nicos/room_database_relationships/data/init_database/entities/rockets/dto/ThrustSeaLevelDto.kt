package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustSeaLevelEntity

data class ThrustSeaLevelDto(
    val kN: Long?,
    val lbf: Long?,
    val rocketId: Int?
)

fun ThrustSeaLevelDto.toThrustSeaLevelEntity(rocketId: Int?) = ThrustSeaLevelEntity(
    id = 0,
    kN = kN,
    lbf = lbf,
    rocketId = rocketId
)
