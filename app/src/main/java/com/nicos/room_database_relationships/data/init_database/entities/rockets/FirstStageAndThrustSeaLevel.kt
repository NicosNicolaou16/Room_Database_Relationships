package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class FirstStageAndThrustSeaLevel(
    @Embedded
    val firstStageEntity: FirstStageEntity,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "rocketId"
    )
    val thrustSeaLevelEntity: ThrustSeaLevelEntity?,
)