package com.nicos.room_database_relationships.data.init_database.entities.rockets

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterRoles
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConvertersDate
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
        internal suspend fun deleteAll(myRoomDatabase: MyRoomDatabase) = with(myRoomDatabase) {
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

        suspend fun getAllRockets(myRoomDatabase: MyRoomDatabase): MutableList<RocketWIthRelationships> {
            val rockets: MutableList<RocketWIthRelationships> =
                myRoomDatabase.rocketsDao().getAllRocketsWithRelationShips()
            return rockets
        }
    }
}