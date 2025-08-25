package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class RocketAndMass(
    @Embedded
    var rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var massEntity: MassEntity,
)