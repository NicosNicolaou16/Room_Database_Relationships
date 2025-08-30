package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class FirstStageAndThrustVacuum(
    @Embedded
    val firstStageEntity: FirstStageEntity,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "rocketId"
    )
    val thrustVacuumEntity: ThrustVacuumEntity?,

    )