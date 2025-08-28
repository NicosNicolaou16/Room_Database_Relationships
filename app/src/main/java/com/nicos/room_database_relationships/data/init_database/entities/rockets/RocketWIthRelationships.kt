package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RocketWIthRelationships(
    @Embedded
    var rocketEntity: RocketsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var firstStageEntity: FirstStageEntity,
    @Relation(
        entity = FirstStageEntity::class,
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var firstStageAndThrustSeaLevel: FirstStageAndThrustSeaLevel,
    @Relation(
        entity = FirstStageEntity::class,
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var firstStageAndThrustVacuum: FirstStageAndThrustVacuum,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var heightEntity: HeightEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var diameterEntity: DiameterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var massEntity: MassEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId"
    )
    var payloadWeightsEntityList: MutableList<PayloadWeightsEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "rocketId",
        associateBy = Junction(
            value = RocketWithPayloadWeightCrossRef::class,
            parentColumn = "id",
            entityColumn = "rocketId"
        )
    )
    var payloadWeightsEntityListManyToMany: MutableList<PayloadWeightsManyToManyEntity>
)
