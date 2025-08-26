package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsEntity

data class PayloadWeightsDto(
    val id: String?,
    val kg: Long?,
    val lb: Long?,
)

fun PayloadWeightsDto.toPayloadWeightsEntity(rocketId: Int): PayloadWeightsEntity {
    return PayloadWeightsEntity(
        ids = 0,
        id = id,
        kg = kg,
        lb = lb,
        rocketId = rocketId
    )
}