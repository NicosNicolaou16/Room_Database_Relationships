package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RocketWithPayloadWeightManyToMany(
    @Embedded
    val rocketsEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "ids",
        associateBy = Junction(
            value = RocketWithPayloadWeightCrossRef::class,
            parentColumn = "rocketId",
            entityColumn = "payloadWeightId"
        )
    )
    val payloadWeightsManyToManyEntityList: MutableList<PayloadWeightsManyToManyEntity>
)