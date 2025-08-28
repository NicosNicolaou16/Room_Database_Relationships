package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterDiameter
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterFirstStage
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterHeight
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterMass
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterPayloadWeight
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterPayloadWeightManyToMany
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterRoles
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConvertersDate
import kotlinx.serialization.Transient
import java.util.Date

data class RocketsDto(
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
    val height: HeightDto?,
    @TypeConverters(ConverterDiameter::class)
    val diameter: DiameterDto?,
    @TypeConverters(ConverterMass::class)
    val mass: MassDto?,
    @TypeConverters(ConverterPayloadWeight::class)
    @SerializedName("payload_weights")
    val payloadWeights: MutableList<PayloadWeightsDto>,
    // Many To Many
    @TypeConverters(ConverterPayloadWeightManyToMany::class)
    val payloadWeightsManyToMany: MutableList<PayloadWeightsDtoManyToMany>,
    @TypeConverters(ConverterFirstStage::class)
    @SerializedName("first_stage")
    val firstStage: FirstStageDto?,
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
)

fun RocketsDto.toRocketEntity(): RocketsEntity {
    return RocketsEntity(
        id = id,
        active = active,
        stages = stages,
        boosters = boosters,
        costPerLaunch = costPerLaunch,
        successRatePct = successRatePct,
        firstFlight = firstFlight,
        country = country,
        company = company,
        wikipedia = wikipedia,
        description = description,
        rocketId = rocketId,
        rocketName = rocketName,
        rocketType = rocketType,
        flickrImages = flickrImages,
    )
}
