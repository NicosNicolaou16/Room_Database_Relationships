package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity

@Entity(primaryKeys = ["id", "rocketId"])
data class RocketWithPayloadWeightCrossRef(
    val id: Int,
    val rocketId: Int,
)
