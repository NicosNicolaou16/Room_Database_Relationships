package com.nicos.room_database_relationships.data.init_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterDiameter
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterFirstStage
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterHeight
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterMass
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterPayloadWeight
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustSeaLevel
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterThrustVacuum
import com.nicos.room_database_relationships.data.init_database.entities.rockets.DiameterEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.FirstStageEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.HeightEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.MassEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustSeaLevelEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustVacuumEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.DiameterDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.FirstStageDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.HeightDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.MassDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.PayloadWeightDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.RocketsDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.ThrustSeaLevelDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dao.ThrustVacuumDao
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConverterRoles
import com.nicos.room_database_relationships.data.init_database.entities.type_converter.ConvertersDate

@Database(
    entities = [
        RocketsEntity::class,
        DiameterEntity::class,
        HeightEntity::class,
        MassEntity::class,
        FirstStageEntity::class,
        PayloadWeightsEntity::class,
        ThrustVacuumEntity::class,
        ThrustSeaLevelEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ConverterDiameter::class,
    ConverterHeight::class,
    ConverterMass::class,
    ConverterFirstStage::class,
    ConverterPayloadWeight::class,
    ConverterThrustSeaLevel::class,
    ConverterThrustVacuum::class,
    ConvertersDate::class,
    ConverterRoles::class
)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun diameterDao(): DiameterDao
    abstract fun heightDao(): HeightDao
    abstract fun massDao(): MassDao
    abstract fun firstStageDao(): FirstStageDao
    abstract fun payloadWeightDao(): PayloadWeightDao
    abstract fun thrustVacuumDao(): ThrustVacuumDao
    abstract fun thrustSeaLevelDao(): ThrustSeaLevelDao
    abstract fun rocketsDao(): RocketsDao

    companion object {
        private const val DB_NAME = "DB_NAME"
        fun initDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyRoomDatabase::class.java,
                DB_NAME
            ).build()
    }
}