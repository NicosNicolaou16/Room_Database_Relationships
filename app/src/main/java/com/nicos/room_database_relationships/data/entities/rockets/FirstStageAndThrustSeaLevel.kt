package com.nicos.room_database_relationships.data.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class FirstStageAndThrustSeaLevel(
    @Embedded
    var firstStageEntity: FirstStageEntity,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "rocketId"
    )
    var thrustSeaLevelEntity: ThrustSeaLevelEntity?,
)