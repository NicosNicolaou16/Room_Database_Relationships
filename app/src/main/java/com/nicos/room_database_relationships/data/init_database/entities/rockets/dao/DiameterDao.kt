package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.nickjetpackprojectandextras.room_database.rockets.DiameterEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

@Dao
interface DiameterDao : BaseDao<DiameterEntity, MutableList<DiameterEntity>> {

    @Transaction
    @Query("SELECT * FROM DiameterEntity WHERE id=:id")
    suspend fun getDiameterById(id: Long): DiameterEntity?

    @Transaction
    @Query("DELETE FROM DiameterEntity")
    suspend fun deleteAll()
}