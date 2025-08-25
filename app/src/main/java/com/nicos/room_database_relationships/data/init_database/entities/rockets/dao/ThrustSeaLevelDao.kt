package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.ThrustSeaLevelEntity

@Dao
interface ThrustSeaLevelDao : BaseDao<ThrustSeaLevelEntity, MutableList<ThrustSeaLevelEntity>> {

    @Transaction
    @Query("DELETE FROM thrustsealevelentity")
    suspend fun deleteAll()
}