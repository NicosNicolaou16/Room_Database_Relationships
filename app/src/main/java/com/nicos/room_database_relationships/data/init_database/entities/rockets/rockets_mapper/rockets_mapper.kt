package com.nicos.room_database_relationships.data.init_database.entities.rockets.rockets_mapper

import com.nick.nickjetpackprojectandextras.room_database.rockets.rockets_mapper.Rockets
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity

fun RocketsEntity.toRocket(): Rockets {
    return Rockets(
        id = id,
        rocketName = rocketName,
        rocketType = rocketType,
        rocketImage = flickrImages?.firstOrNull()
    )
}