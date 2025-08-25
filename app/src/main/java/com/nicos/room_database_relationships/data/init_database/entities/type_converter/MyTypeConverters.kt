package com.nick.nickjetpackprojectandextras.room_database.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nick.nickjetpackprojectandextras.room_database.rockets.*
import com.nicos.room_database_relationships.data.entities.rockets.DiameterEntity
import com.nicos.room_database_relationships.data.entities.rockets.FirstStageEntity
import com.nicos.room_database_relationships.data.entities.rockets.ThrustSeaLevelEntity
import com.nicos.room_database_relationships.data.entities.rockets.ThrustVacuumEntity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ConverterHeight {

    @TypeConverter
    fun fromStringToHeight(value: String): HeightEntity? {
        return Gson().fromJson(value, object : TypeToken<HeightEntity>() {}.type)
    }

    @TypeConverter
    fun fromHeightsToString(heightEntity: HeightEntity): String = Gson().toJson(heightEntity)
}

class ConverterDiameter {

    @TypeConverter
    fun fromStringToDiameter(value: String): DiameterEntity? {
        return Gson().fromJson(value, object : TypeToken<DiameterEntity>() {}.type)
    }

    @TypeConverter
    fun fromDiameterToString(diameterEntity: DiameterEntity?): String =
        Gson().toJson(diameterEntity)
}

class ConverterMass {

    @TypeConverter
    fun fromStringToMass(value: String): MassEntity? {
        return Gson().fromJson(value, object : TypeToken<MassEntity>() {}.type)
    }

    @TypeConverter
    fun fromMassToString(massEntity: MassEntity?): String = Gson().toJson(massEntity)
}

class ConverterPayloadWeight {

    @TypeConverter
    fun fromStringToPayloadWeightList(value: String): MutableList<PayloadWeightsEntity>? {
        return Gson().fromJson(
            value,
            object : TypeToken<MutableList<PayloadWeightsEntity>>() {}.type
        )
    }

    @TypeConverter
    fun fromPayloadWeightListToString(payloadWeightsEntityList: MutableList<PayloadWeightsEntity>?): String =
        Gson().toJson(payloadWeightsEntityList)
}

class ConverterFirstStage {

    @TypeConverter
    fun fromStringToFirstStateModel(value: String): FirstStageEntity? {
        return Gson().fromJson(value, object : TypeToken<FirstStageEntity>() {}.type)
    }

    @TypeConverter
    fun fromFirstStateModelToString(firstStageEntity: FirstStageEntity?): String =
        Gson().toJson(firstStageEntity)
}

class ConverterThrustSeaLevel {

    @TypeConverter
    fun fromStringToThrustSeaLevelModel(value: String): ThrustSeaLevelEntity? {
        return Gson().fromJson(value, object : TypeToken<ThrustSeaLevelEntity>() {}.type)
    }

    @TypeConverter
    fun fromThrustSeaLevelModelToString(thrustSeaLevelEntity: ThrustSeaLevelEntity?): String =
        Gson().toJson(thrustSeaLevelEntity)
}

class ConverterThrustVacuum {

    @TypeConverter
    fun fromStringToThrustVacuumModel(value: String): ThrustVacuumEntity? {
        return Gson().fromJson(value, object : TypeToken<ThrustVacuumEntity>() {}.type)
    }

    @TypeConverter
    fun fromThrustVacuumModelToString(thrustVacuumEntity: ThrustVacuumEntity?): String =
        Gson().toJson(thrustVacuumEntity)
}

class ConvertersDate {
    var simpleDateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    @TypeConverter
    fun fromStringToDate(timestamp: String?): Date? {
        return timestamp?.let { simpleDateFormat.parse(timestamp) }
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return date?.let { simpleDateFormat.format(it) }
    }
}

class ConverterRoles {

    @TypeConverter
    fun fromStringToRolesStringList(value: String): MutableList<String>? {
        return Gson().fromJson(value, object : TypeToken<MutableList<String>>() {}.type)
    }

    @TypeConverter
    fun fromRolesListToString(rolesList: MutableList<String>?): String = Gson().toJson(rolesList)
}


