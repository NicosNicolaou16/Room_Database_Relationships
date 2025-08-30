package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["rocketId"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = RocketsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("rocketId"),
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class FirstStageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val reusable: Boolean?,
    val engines: Int?,
    val fuelAmountTons: Double?,
    val burnTimeSec: Long?,
    val thrustSeaLevel: ThrustSeaLevelEntity?,
    val thrustVacuum: ThrustVacuumEntity?,
    val rocketId: Int?
)