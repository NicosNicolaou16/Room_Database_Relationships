package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class RocketAndDiameter(
    @Embedded
    val rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val diameterEntity: DiameterEntity?,
)