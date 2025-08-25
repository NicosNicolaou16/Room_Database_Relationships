package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["rocketId"])],
    foreignKeys = [
        ForeignKey(
            entity = RocketsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("rocketId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HeightEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var meters: Double?,
    var feet: Double?,
    var rocketId: Int?
) {

    companion object {
        suspend fun insertHeight(
            heightEntity: HeightEntity?,
            rocketId: Int?,
            myRoomDatabase: MyRoomDatabase
        ) {
            if (heightEntity == null) return
            heightEntity.rocketId = rocketId
            myRoomDatabase.heightDao().insertObject(heightEntity)
        }
    }
}