package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.HeightEntity

data class HeightDto(
    var meters: Double?,
    var feet: Double?,
)

fun HeightDto.toHeightEntity(rocketId: Int) = HeightEntity(
    meters = meters,
    feet = feet,
    rocketId = rocketId
)
