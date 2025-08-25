package com.nick.nickjetpackprojectandextras.room_database.rockets.rockets_mapper

import com.nick.nickjetpackprojectandextras.room_database.rockets.RocketsEntity

fun RocketsEntity.toRocket(): Rockets {
    return Rockets(
        id = id,
        rocketName = rocketName,
        rocketType = rocketType,
        rocketImage = flickrImages?.firstOrNull()
    )
}