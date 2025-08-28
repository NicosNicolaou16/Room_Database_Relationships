package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Relation

data class PayloadWeightWithRocketManyToMany(
    @Embedded
    var payloadWeightsEntity: PayloadWeightsEntity,
    @Relation(
        parentColumn = "rocketId",
        entityColumn = "id"
    )
    var rocketsEntity: RocketsEntity
)
