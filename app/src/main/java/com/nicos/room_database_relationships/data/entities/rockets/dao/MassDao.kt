package com.nicos.room_database_relationships.data.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.entities.rockets.MassEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

@Dao
interface MassDao : BaseDao<MassEntity, MutableList<MassEntity>> {

    @Transaction
    @Query("SELECT * FROM MassEntity WHERE id=:id")
    suspend fun getMassById(id: Long): MassEntity?

    @Transaction
    @Query("DELETE FROM MassEntity")
    suspend fun deleteAll()
}