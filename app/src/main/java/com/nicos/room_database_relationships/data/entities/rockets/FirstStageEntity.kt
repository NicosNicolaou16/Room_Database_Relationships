package com.nick.nickjetpackprojectandextras.room_database.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nick.nickjetpackprojectandextras.room_database.init_database.MyRoomDatabase
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterThrustSeaLevel
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterThrustVacuum

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
    @SerializedName("fuel_amount_tons")
    var fuelAmountTons: Double?,
    @SerializedName("burn_time_sec")
    var burnTimeSec: Long?,
    @TypeConverters(ConverterThrustSeaLevel::class)
    @SerializedName("thrust_sea_level")
    var thrustSeaLevel: ThrustSeaLevelEntity?,
    @TypeConverters(ConverterThrustVacuum::class)
    @SerializedName("thrust_vacuum")
    var thrustVacuum: ThrustVacuumEntity?,
    var rocketId: Int?
) {
    companion object {
        suspend fun insertFirstStage(
            firstStageEntity: FirstStageEntity?,
            rocketId: Int?,
            myRoomDatabase: MyRoomDatabase
        ) {
            if (firstStageEntity == null) return
            firstStageEntity.rocketId = rocketId
            myRoomDatabase.firstStageDao().insertObject(firstStageEntity)

            insertThrustSeaLevel(
                firstStageEntity = firstStageEntity,
                myRoomDatabase = myRoomDatabase
            )
            insertThrustVacuum(
                firstStageEntity = firstStageEntity,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun insertThrustSeaLevel(
            firstStageEntity: FirstStageEntity?,
            myRoomDatabase: MyRoomDatabase
        ) {
            ThrustSeaLevelEntity.insertThrustSeaLevel(
                thrustSeaLevelEntity = firstStageEntity?.thrustSeaLevel,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun insertThrustVacuum(
            firstStageEntity: FirstStageEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            ThrustVacuumEntity.insertThrustSeaLevel(
                thrustVacuumEntity = firstStageEntity.thrustVacuum,
                myRoomDatabase = myRoomDatabase
            )
        }
    }
}