package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsManyToManyEntity

@Dao
interface PayloadWeightManyToManyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(payloadWeight: PayloadWeightsManyToManyEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(payloadWeights: MutableList<PayloadWeightsManyToManyEntity>)
}