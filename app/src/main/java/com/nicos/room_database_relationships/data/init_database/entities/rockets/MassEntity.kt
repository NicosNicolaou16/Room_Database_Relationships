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
data class MassEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val kg: Long?,
    val lb: Long?,
    var rocketId: Int?
) {

    companion object {
        suspend fun insertMass(
            massEntity: MassEntity?,
            rocketId: Int?,
            myRoomDatabase: MyRoomDatabase
        ) {
            if (massEntity == null) return
            massEntity.rocketId = rocketId
            myRoomDatabase.massDao().insertObject(massEntity)
        }
    }
}