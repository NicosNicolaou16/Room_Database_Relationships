package com.nicos.room_database_relationships.data.init_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
@TypeConverters()
abstract class MyRoomDatabase : RoomDatabase() {

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