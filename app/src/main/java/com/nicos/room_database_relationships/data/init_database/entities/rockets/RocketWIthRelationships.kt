package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RocketWIthRelationships(
    @Embedded
    val rocketEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val firstStageEntity: FirstStageEntity,
    @Relation(
        entity = FirstStageEntity::class,
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val firstStageAndThrustSeaLevel: FirstStageAndThrustSeaLevel,
    @Relation(
        entity = FirstStageEntity::class,
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val firstStageAndThrustVacuum: FirstStageAndThrustVacuum,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val heightEntity: HeightEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val diameterEntity: DiameterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val massEntity: MassEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    val payloadWeightsEntityList: MutableList<PayloadWeightsEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "ids",
        associateBy = Junction(
            value = RocketWithPayloadWeightCrossRef::class,
            parentColumn = "rocketId",
            entityColumn = "payloadWeightId"
        )
    )
    val payloadWeightsEntityListManyToMany: MutableList<PayloadWeightsManyToManyEntity>
)
