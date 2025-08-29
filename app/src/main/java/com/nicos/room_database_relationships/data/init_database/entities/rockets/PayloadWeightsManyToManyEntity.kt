package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["ids"], unique = true)],
)
data class PayloadWeightsManyToManyEntity(
    @PrimaryKey(autoGenerate = true)
    val ids: Long = 0,
    val id: String?,
    val kg: Long?,
    val lb: Long?,
)
