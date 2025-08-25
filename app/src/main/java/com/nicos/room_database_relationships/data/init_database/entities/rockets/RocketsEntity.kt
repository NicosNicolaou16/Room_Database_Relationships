package com.nicos.room_database_relationships.data.init_database.entities.rockets

import android.util.Log
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterDiameter
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterFirstStage
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterHeight
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterMass
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterPayloadWeight
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConverterRoles
import com.nick.nickjetpackprojectandextras.room_database.type_converter.ConvertersDate
import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow
import java.util.Date

@Entity(
    indices = [Index(value = ["id"], unique = true)],
)
data class RocketsEntity(
    @PrimaryKey
    val id: Int,
    val active: Boolean?,
    val stages: Int?,
    val boosters: Int?,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Long?,
    @SerializedName("success_rate_pct")
    val successRatePct: Int?,
    @TypeConverters(ConvertersDate::class)
    @SerializedName("first_flight")
    val firstFlight: Date?,
    val country: String?,
    val company: String?,
    @TypeConverters(ConverterHeight::class)
    val height: HeightEntity?,
    @TypeConverters(ConverterDiameter::class)
    val diameter: DiameterEntity?,
    @TypeConverters(ConverterMass::class)
    val mass: MassEntity?,
    @TypeConverters(ConverterPayloadWeight::class)
    @SerializedName("payload_weights")
    val payloadWeights: MutableList<PayloadWeightsEntity>,
    @TypeConverters(ConverterFirstStage::class)
    @SerializedName("first_stage")
    val firstStage: FirstStageEntity?,
    val wikipedia: String?,
    val description: String?,
    @SerializedName("rocket_id")
    val rocketId: String?,
    @SerializedName("rocket_name")
    val rocketName: String?,
    @SerializedName("rocket_type")
    val rocketType: String?,
    @TypeConverters(ConverterRoles::class)
    @SerializedName("flickr_images")
    val flickrImages: MutableList<String>?
) {
    companion object {
        suspend fun insertRockets(
            rocketsEntityList: MutableList<RocketsEntity>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                Log.d("threadName", "2 " + Thread.currentThread().name.toString())
                deleteAll(myRoomDatabase)
                myRoomDatabase.rocketsDao().insertOrReplaceList(rocketsEntityList)
                rocketsEntityList.forEach {
                    saveHeightData(rocketsEntity = it, myRoomDatabase = myRoomDatabase)
                    saveDiameterData(rocketsEntity = it, myRoomDatabase = myRoomDatabase)
                    saveMassData(rocketsEntity = it, myRoomDatabase = myRoomDatabase)
                    savePayloadWeightsData(rocketsEntity = it, myRoomDatabase = myRoomDatabase)
                    saveFirstStage(rocketsEntity = it, myRoomDatabase = myRoomDatabase)
                }
                emit(rocketsEntityList)
            }

        private suspend fun saveHeightData(
            rocketsEntity: RocketsEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            HeightEntity.insertHeight(
                heightEntity = rocketsEntity.height,
                rocketId = rocketsEntity.id,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun saveDiameterData(
            rocketsEntity: RocketsEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            DiameterEntity.insertDiameter(
                diameterEntity = rocketsEntity.diameter,
                rocketId = rocketsEntity.id,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun saveMassData(
            rocketsEntity: RocketsEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            MassEntity.insertMass(
                massEntity = rocketsEntity.mass,
                rocketId = rocketsEntity.id,
                myRoomDatabase = myRoomDatabase
            )
        }

        private suspend fun savePayloadWeightsData(
            rocketsEntity: RocketsEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            PayloadWeightsEntity.insertPayloadWeights(
                rocketsEntity.payloadWeights,
                rocketsEntity.id,
                myRoomDatabase
            )
        }

        private suspend fun saveFirstStage(
            rocketsEntity: RocketsEntity,
            myRoomDatabase: MyRoomDatabase
        ) {
            FirstStageEntity.insertFirstStage(
                rocketsEntity.firstStage,
                rocketsEntity.id,
                myRoomDatabase
            )
        }

        private suspend fun deleteAll(myRoomDatabase: MyRoomDatabase) = with(myRoomDatabase) {
            rocketsDao().deleteAll()
            heightDao().deleteAll()
            diameterDao().deleteAll()
            massDao().deleteAll()
            payloadWeightDao().deleteAll()
            firstStageDao().deleteAll()
            thrustSeaLevelDao().deleteAll()
            thrustVacuumDao().deleteAll()
        }

        suspend fun getRocketById(
            id: Int,
            myRoomDatabase: MyRoomDatabase
        ): RocketWIthRelationships? {
            val rocket = myRoomDatabase.rocketsDao().getRocketByIdWithRelation(id)
            return rocket
        }

        suspend fun getAllRockets(myRoomDatabase: MyRoomDatabase): MutableList<RocketWIthRelationships>? {
            val rockets: MutableList<RocketWIthRelationships> =
                myRoomDatabase.rocketsDao().getAllRocketsWithRelationShips()
            return rockets
        }
    }
}