package com.nicos.room_database_relationships.data.init_database.entities.rockets.rockets_mapper

import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity

fun RocketsEntity.toRocket(): RocketsUi {
    return RocketsUi(
        id = id,
        rocketName = rocketName,
        rocketType = rocketType,
        rocketImage = flickrImages?.firstOrNull()
    )
}