package com.nicos.room_database_relationships.data.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.entities.rockets.ThrustVacuumEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

@Dao
interface ThrustVacuumDao: BaseDao<ThrustVacuumEntity, MutableList<ThrustVacuumEntity>> {

    @Transaction
    @Query("DELETE FROM thrustvacuumentity")
    suspend fun deleteAll()
}