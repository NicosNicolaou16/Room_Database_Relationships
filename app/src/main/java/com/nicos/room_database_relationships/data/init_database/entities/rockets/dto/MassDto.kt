package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import com.nicos.room_database_relationships.data.init_database.entities.rockets.MassEntity

data class MassDto(
    val kg: Long?,
    val lb: Long?,
)

fun MassDto.toMassEntity(rocketId: Int?): MassEntity {
    return MassEntity(
        id = 0,
        kg = kg,
        lb = lb,
        rocketId = rocketId
    )
}
