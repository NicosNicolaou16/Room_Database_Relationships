package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class FirstStageAndThrustVacuum(
    @Embedded
    var firstStageEntity: FirstStageEntity,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "rocketId"
    )
    var thrustVacuumEntity: ThrustVacuumEntity?,

    )