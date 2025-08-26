package com.nicos.room_database_relationships.data.init_database.entities.rockets.dto

import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nicos.room_database_relationships.data.init_database.entities.rockets.FirstStageEntity
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustSeaLevel
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustVacuum

data class FirstStageDto(
    var reusable: Boolean?,
    var engines: Int?,
    @SerializedName("fuel_amount_tons")
    var fuelAmountTons: Double?,
    @SerializedName("burn_time_sec")
    var burnTimeSec: Long?,
    @TypeConverters(ConverterThrustSeaLevel::class)
    @SerializedName("thrust_sea_level")
    var thrustSeaLevelDto: ThrustSeaLevelDto?,
    @TypeConverters(ConverterThrustVacuum::class)
    @SerializedName("thrust_vacuum")
    var thrustVacuumDto: ThrustVacuumDto?,
    var rocketId: Int?
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
