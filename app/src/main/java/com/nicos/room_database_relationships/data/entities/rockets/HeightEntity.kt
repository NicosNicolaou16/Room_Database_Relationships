package com.nick.nickjetpackprojectandextras.room_database.rockets

import android.util.Log
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nick.nickjetpackprojectandextras.room_database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

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