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
    var id: Long,
    var reusable: Boolean?,
    var engines: Int?,
    var fuelAmountTons: Double?,
    var burnTimeSec: Long?,
    var thrustSeaLevel: ThrustSeaLevelEntity?,
    var thrustVacuum: ThrustVacuumEntity?,
    var rocketId: Int?
)