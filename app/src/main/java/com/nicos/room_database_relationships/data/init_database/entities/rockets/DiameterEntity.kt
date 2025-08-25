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
            entity = RocketsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("rocketId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DiameterEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var meters: Double?,
    var feet: Double?,
    var rocketId: Int?
) {

    companion object {
        suspend fun insertDiameter(
            diameterEntity: DiameterEntity?,
            rocketId: Int?,
            myRoomDatabase: MyRoomDatabase
        ) {
            if (diameterEntity == null) return
            diameterEntity.rocketId = rocketId
            myRoomDatabase.diameterDao().insertObject(diameterEntity)
        }
    }
}