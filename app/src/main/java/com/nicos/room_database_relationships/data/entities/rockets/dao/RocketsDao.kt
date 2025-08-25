package com.nicos.room_database_relationships.data.entities.rockets.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.nickjetpackprojectandextras.room_database.rockets.RocketWIthRelationships
import com.nick.nickjetpackprojectandextras.room_database.rockets.RocketsEntity
import com.nicos.room_database_relationships.data.init_database.BaseDao

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
    @Query("DELETE FROM RocketsEntity")
    suspend fun deleteAll()
}