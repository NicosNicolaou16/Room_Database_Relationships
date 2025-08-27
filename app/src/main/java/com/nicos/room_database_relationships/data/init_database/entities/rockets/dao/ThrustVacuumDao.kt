package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustVacuumEntity

@Dao
interface ThrustVacuumDao : BaseDao<ThrustVacuumEntity, MutableList<ThrustVacuumEntity>> {

    @Transaction
    @Query("SELECT * FROM thrustvacuumentity WHERE id=:id")
    suspend fun getThrustVacuumById(id: Long): ThrustVacuumEntity?

    @Transaction
    @Query("DELETE FROM thrustvacuumentity")
    suspend fun deleteAll()
}