package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.HeightEntity

@Dao
interface HeightDao : BaseDao<HeightEntity, MutableList<HeightEntity>> {

    @Transaction
    @Query("SELECT * FROM heightentity WHERE id=:id")
    suspend fun getHeightById(id: Long): HeightEntity?

    @Transaction
    @Query("DELETE FROM HeightEntity")
    suspend fun deleteAll()
}