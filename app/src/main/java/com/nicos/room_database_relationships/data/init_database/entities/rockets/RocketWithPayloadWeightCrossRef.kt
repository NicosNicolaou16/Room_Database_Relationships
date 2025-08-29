package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity

@Entity(primaryKeys = ["rocketId", "payloadWeightId"])
data class RocketWithPayloadWeightCrossRef(
    val rocketId: Int,
    val payloadWeightId: Long,
)
