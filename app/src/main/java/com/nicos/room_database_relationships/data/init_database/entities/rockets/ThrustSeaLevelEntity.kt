package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["rocketId"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = FirstStageEntity::class,
            parentColumns = arrayOf("rocketId"),
            childColumns = arrayOf("rocketId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ThrustSeaLevelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val kN: Long?,
    val lbf: Long?,
    val rocketId: Int?
)