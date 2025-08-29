package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PayloadWeightWithRocketManyToMany(
    @Embedded
    val payloadWeightsEntity: PayloadWeightsManyToManyEntity,
    @Relation(
        parentColumn = "ids",
        entityColumn = "id",
        associateBy = Junction(
            value = RocketWithPayloadWeightCrossRef::class,
            parentColumn = "payloadWeightId",
            entityColumn = "rocketId"
        )
    )
    val rocketsEntity: MutableList<RocketsEntity>
)
