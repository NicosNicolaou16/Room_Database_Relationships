package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RocketWithPayloadWeightManyToMany(
    @Embedded
    var rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId",
        associateBy = Junction(RocketWithPayloadWeightCrossRef::class)
    )
    var payloadWeightsEntityList: MutableList<PayloadWeightsEntity>
)