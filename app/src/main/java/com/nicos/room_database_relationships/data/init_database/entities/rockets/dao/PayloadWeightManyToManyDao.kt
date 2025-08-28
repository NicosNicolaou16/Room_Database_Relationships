package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightWithRocketManyToMany
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsManyToManyEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWithPayloadWeightManyToMany

@Dao
interface PayloadWeightManyToManyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(payloadWeight: PayloadWeightsManyToManyEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(payloadWeights: MutableList<PayloadWeightsManyToManyEntity>)

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id = :rocketId")
    suspend fun getRocketWithPayloads(rocketId: Int): List<RocketWithPayloadWeightManyToMany>

    @Transaction
    @Query("SELECT * FROM PayloadWeightsEntity WHERE id = :payloadId")
    suspend fun getPayloadWithRockets(payloadId: Int): List<PayloadWeightWithRocketManyToMany>

}