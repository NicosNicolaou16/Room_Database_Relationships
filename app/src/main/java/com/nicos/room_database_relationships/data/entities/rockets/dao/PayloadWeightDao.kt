package com.nicos.room_database_relationships.data.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.nickjetpackprojectandextras.room_database.rockets.PayloadWeightsEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

@Dao
interface PayloadWeightDao : BaseDao<PayloadWeightsEntity, MutableList<PayloadWeightsEntity>> {

    @Transaction
    @Query("SELECT * FROM PayloadWeightsEntity WHERE rocketId =:rocketId")
    suspend fun getPayloadWeightsByRocketId(rocketId: Int): MutableList<PayloadWeightsEntity>

    @Transaction
    @Query("DELETE FROM PayloadWeightsEntity")
    suspend fun deleteAll()
}