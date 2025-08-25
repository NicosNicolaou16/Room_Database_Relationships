package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsEntity

@Dao
interface PayloadWeightDao : BaseDao<PayloadWeightsEntity, MutableList<PayloadWeightsEntity>> {

    @Transaction
    @Query("SELECT * FROM PayloadWeightsEntity WHERE rocketId =:rocketId")
    suspend fun getPayloadWeightsByRocketId(rocketId: Int): MutableList<PayloadWeightsEntity>

    @Transaction
    @Query("DELETE FROM PayloadWeightsEntity")
    suspend fun deleteAll()
}