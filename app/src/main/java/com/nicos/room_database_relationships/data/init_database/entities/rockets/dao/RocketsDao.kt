package com.nicos.room_database_relationships.data.init_database.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nicos.room_database_relationships.data.init_database.BaseDao
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketAndDiameter
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketAndFirstStage
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketAndHeight
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketAndMass
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWIthRelationships
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWithPayloadWeight
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity

@Dao
interface RocketsDao : BaseDao<RocketsEntity, MutableList<RocketsEntity>> {

    @Transaction
    @Query("SELECT * FROM rocketsentity WHERE id=:id")
    suspend fun getRocketById(id: Int): RocketsEntity

    @Transaction
    @Query("SELECT * FROM rocketsentity WHERE id=:id")
    suspend fun getRocketByIdWithRelation(id: Int): RocketWIthRelationships?

    @Transaction
    @Query("SELECT * FROM rocketsentity")
    suspend fun getAllRockets(): MutableList<RocketsEntity>

    @Transaction
    @Query("SELECT * FROM rocketsentity")
    suspend fun getAllRocketsWithRelationShips(): MutableList<RocketWIthRelationships>

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id=:rocketId")
    suspend fun getRocketsAndDiameter(rocketId: Int): RocketAndDiameter?

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id=:rocketId")
    suspend fun getRocketsAndHeight(rocketId: Int): RocketAndHeight?

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id=:rocketId")
    suspend fun getRocketsAndMass(rocketId: Int): RocketAndMass?

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id=:rocketId")
    suspend fun getRocketsAndFirstStage(rocketId: Int): RocketAndFirstStage?

    @Transaction
    @Query("SELECT * FROM RocketsEntity WHERE id=:id")
    suspend fun getPayloadWeightById(id: Long): RocketWithPayloadWeight?

    @Transaction
    @Query("DELETE FROM RocketsEntity")
    suspend fun deleteAll()
}