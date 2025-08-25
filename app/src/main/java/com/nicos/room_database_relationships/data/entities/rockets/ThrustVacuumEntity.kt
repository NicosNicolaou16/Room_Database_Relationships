package com.nicos.room_database_relationships.data.entities.rockets

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
data class ThrustVacuumEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var kN: Long?,
    var lbf: Long?,
    var rocketId: Int?
) {
    companion object {
        suspend fun insertThrustSeaLevel(
            thrustVacuumEntity: ThrustVacuumEntity?,
            myRoomDatabase: MyRoomDatabase
        )  {
            if(thrustVacuumEntity == null) return
            thrustVacuumEntity.rocketId = thrustVacuumEntity.rocketId
            myRoomDatabase.thrustVacuumDao().insertObject(thrustVacuumEntity)
        }
    }
}