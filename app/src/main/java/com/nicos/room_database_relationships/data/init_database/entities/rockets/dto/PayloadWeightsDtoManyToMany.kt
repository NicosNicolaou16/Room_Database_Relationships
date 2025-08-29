package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsManyToManyEntity

data class PayloadWeightsDtoManyToMany(
    val id: String?,
    val kg: Long?,
    val lb: Long?,
)

fun PayloadWeightsDtoManyToMany.toPayloadWeightsManyToManyEntity(): PayloadWeightsManyToManyEntity {
    return PayloadWeightsManyToManyEntity(
        ids = 0,
        id = id,
        kg = kg,
        lb = lb,
    )
}