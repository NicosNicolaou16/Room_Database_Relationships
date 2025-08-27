package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["rocketId"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = RocketsEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("rocketId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class PayloadWeightsManyToManyEntity(
    @PrimaryKey(autoGenerate = true)
    val ids: Long,
    val id: String?,
    val kg: Long?,
    val lb: Long?,
    var rocketId: Int
)
