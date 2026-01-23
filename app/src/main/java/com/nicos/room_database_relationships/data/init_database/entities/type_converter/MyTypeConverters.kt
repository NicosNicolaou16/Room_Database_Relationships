package com.nicos.room_database_relationships.data.init_database.entities.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustSeaLevelEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustVacuumEntity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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


