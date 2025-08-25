package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.FirstStageEntity

@Dao
interface FirstStageDao : BaseDao<FirstStageEntity, MutableList<FirstStageEntity>> {

    @Transaction
    @Query("SELECT * FROM firststageentity WHERE id=:id")
    suspend fun getFirstStageById(id: Long): FirstStageEntity?

    @Transaction
    @Query("DELETE FROM firststageentity")
    suspend fun deleteAll()
}