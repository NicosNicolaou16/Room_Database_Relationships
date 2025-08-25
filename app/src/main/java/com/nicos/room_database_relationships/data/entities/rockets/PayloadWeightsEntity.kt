package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nick.nickjetpackprojectandextras.room_database.init_database.MyRoomDatabase

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["rocketId"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = RocketsEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("rocketId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class PayloadWeightsEntity(
    @PrimaryKey(autoGenerate = true)
    val ids: Long,
    val id: String?,
    val kg: Long?,
    val lb: Long?,
    var rocketId: Int
) {

    companion object {
        suspend fun insertPayloadWeights(
            payloadWeightsEntityList: MutableList<PayloadWeightsEntity>,
            rocketId: Int,
            myRoomDatabase: MyRoomDatabase
        ) {
            payloadWeightsEntityList.forEach {
                it.rocketId = rocketId
            }
            myRoomDatabase.payloadWeightDao().insertOrReplaceList(payloadWeightsEntityList)
        }
    }
}