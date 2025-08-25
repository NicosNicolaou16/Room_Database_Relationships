package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nick.nickjetpackprojectandextras.room_database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

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
    var id: Long,
    var kN: Long?,
    var lbf: Long?,
    var rocketId: Int?
) {

    companion object {
        suspend fun insertThrustSeaLevel(
            thrustSeaLevelEntity: ThrustSeaLevelEntity?,
            myRoomDatabase: MyRoomDatabase
        ) {
            if(thrustSeaLevelEntity == null) return
            thrustSeaLevelEntity.rocketId = thrustSeaLevelEntity.rocketId
            myRoomDatabase.thrustSeaLevelDao().insertObject(thrustSeaLevelEntity)
        }
    }
}