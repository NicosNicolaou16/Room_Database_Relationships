package com.nicos.room_database_relationships.domain.repositories

import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWIthRelationships
import kotlinx.coroutines.flow.Flow

interface RocketsRepository {
    suspend fun getRockets(): Flow<MutableList<RocketWIthRelationships>>
}