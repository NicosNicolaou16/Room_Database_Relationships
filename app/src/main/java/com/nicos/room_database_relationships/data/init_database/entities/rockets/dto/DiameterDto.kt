package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.DiameterEntity

data class DiameterDto(
    val meters: Double?,
    val feet: Double?
)

fun DiameterDto.toDiameterEntity(rocketId: Int?): DiameterEntity {
    return DiameterEntity(
        id = 0,
        meters = meters,
        feet = feet,
        rocketId = rocketId
    )
}
