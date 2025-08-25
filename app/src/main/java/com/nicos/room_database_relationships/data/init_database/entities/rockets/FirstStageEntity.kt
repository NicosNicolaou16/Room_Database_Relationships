package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustSeaLevel
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustVacuum
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
            ThrustSeaLevelEntity.Companion.insertThrustSeaLevel(
                thrustSeaLevelEntity = firstStageEntity?.thrustSeaLevel,
                rocketId = firstStageEntity?.rocketId,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun insertThrustVacuum(
            firstStageEntity: FirstStageEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            ThrustVacuumEntity.Companion.insertThrustSeaLevel(
                thrustVacuumEntity = firstStageEntity.thrustVacuum,
                rocketId = firstStageEntity.rocketId,
                myRoomDatabase = myRoomDatabase
            )
        }
    }
}