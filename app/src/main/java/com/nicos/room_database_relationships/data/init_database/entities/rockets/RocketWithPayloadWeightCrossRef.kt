package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.Index

@Entity(
    primaryKeys = ["rocketId", "payloadWeightId"],
    indices = [Index(value = ["payloadWeightId"])]
)
data class RocketWithPayloadWeightCrossRef(
    val rocketId: Int,
    val payloadWeightId: Long,
)
