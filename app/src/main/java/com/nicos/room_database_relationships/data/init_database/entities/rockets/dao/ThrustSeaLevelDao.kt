package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.entities.rockets.ThrustSeaLevelEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

@Dao
interface ThrustSeaLevelDao : BaseDao<ThrustSeaLevelEntity, MutableList<ThrustSeaLevelEntity>> {

    @Transaction
    @Query("DELETE FROM thrustsealevelentity")
    suspend fun deleteAll()
}