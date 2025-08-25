package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class RocketAndDiameter(
    @Embedded
    var rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var diameterEntity: DiameterEntity?,
) {
}