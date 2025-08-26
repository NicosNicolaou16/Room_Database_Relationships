package com.nicos.room_database_relationships.data.repositoriesImpl

import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWIthRelationships
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity
import com.nicos.room_database_relationships.domain.network.RocketsService
import com.nicos.room_database_relationships.domain.repositories.RocketsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RocketsRepositoryImpl @Inject constructor(
    private val rocketsService: RocketsService,
    private val myRoomDatabase: MyRoomDatabase
) : RocketsRepository {
    override suspend fun getRockets(): Flow<MutableList<RocketWIthRelationships>> {
        return flow {
            val rockets = rocketsService.getRockets()
           /* RocketsEntity.insertRockets(
                rocketsEntityList = rockets,
                myRoomDatabase = myRoomDatabase
            ).collect()*/
            val rocketsEntity: MutableList<RocketWIthRelationships> =
                RocketsEntity.getAllRockets(myRoomDatabase)
            emit(rocketsEntity)
        }.flowOn(Dispatchers.IO)
    }
}