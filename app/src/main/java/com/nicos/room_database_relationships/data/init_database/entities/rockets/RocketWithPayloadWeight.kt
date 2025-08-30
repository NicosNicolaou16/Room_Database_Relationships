package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class RocketWithPayloadWeight(
    @Embedded
    val rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val payloadWeightsEntityList: MutableList<PayloadWeightsEntity>
)