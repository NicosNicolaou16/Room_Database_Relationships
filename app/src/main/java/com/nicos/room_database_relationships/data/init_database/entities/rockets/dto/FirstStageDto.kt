package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nicos.room_database_relationships.data.init_database.entities.rockets.FirstStageEntity
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustSeaLevel
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustVacuum

data class FirstStageDto(
    val reusable: Boolean?,
    val engines: Int?,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    @SerializedName("burn_time_sec")
    val burnTimeSec: Long?,
    @TypeConverters(ConverterThrustSeaLevel::class)
    @SerializedName("thrust_sea_level")
    val thrustSeaLevelDto: ThrustSeaLevelDto?,
    @TypeConverters(ConverterThrustVacuum::class)
    @SerializedName("thrust_vacuum")
    val thrustVacuumDto: ThrustVacuumDto?,
    val rocketId: Int?
)

fun FirstStageDto.toFirstStageEntity(rocketId: Int?) = FirstStageEntity(
    id = 0,
    reusable = reusable,
    engines = engines,
    fuelAmountTons = fuelAmountTons,
    burnTimeSec = burnTimeSec,
    thrustSeaLevel = thrustSeaLevelDto?.toThrustSeaLevelEntity(rocketId),
    thrustVacuum = thrustVacuumDto?.toThrustVacuumEntity(rocketId),
    rocketId = rocketId
)
