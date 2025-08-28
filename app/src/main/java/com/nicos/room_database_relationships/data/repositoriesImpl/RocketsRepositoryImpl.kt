package com.nicos.room_database_relationships.data.repositoriesImpl

import androidx.room.withTransaction
import com.nicos.room_database_relationships.data.init_database.MyRoomDatabase
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.PayloadWeightsManyToManyEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWIthRelationships
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketWithPayloadWeightCrossRef
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.PayloadWeightsDtoManyToMany
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.RocketsDto
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toDiameterEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toFirstStageEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toHeightEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toMassEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toPayloadWeightsEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toPayloadWeightsManyToManyEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toRocketEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toThrustSeaLevelEntity
import com.nicos.room_database_relationships.data.init_database.entities.rockets.dto.toThrustVacuumEntity
import com.nicos.room_database_relationships.domain.network.RocketsService
import com.nicos.room_database_relationships.domain.repositories.RocketsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
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
            saveRocketInLocalDatabase(rockets)
            val rocketsEntity: MutableList<RocketWIthRelationships> =
                RocketsEntity.getAllRockets(myRoomDatabase)
            emit(rocketsEntity)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun saveRocketInLocalDatabase(rocketsDto: MutableList<RocketsDto>) {
        myRoomDatabase.withTransaction {
            RocketsEntity.deleteAll(myRoomDatabase)

            rocketsDto.forEach { it ->
                val payloadWeightsDtoManyToManyList = mutableListOf<PayloadWeightsDtoManyToMany>()
                val rocketEntity = it.toRocketEntity()
                myRoomDatabase.rocketsDao().insertObject(data = rocketEntity)
                if (it.height != null) {
                    myRoomDatabase.heightDao()
                        .insertObject(data = it.height.toHeightEntity(rocketEntity.id))
                }
                if (it.diameter != null) {
                    myRoomDatabase.diameterDao()
                        .insertObject(data = it.diameter.toDiameterEntity(rocketEntity.id))
                }
                if (it.mass != null) {
                    myRoomDatabase.massDao()
                        .insertObject(data = it.mass.toMassEntity(rocketEntity.id))
                }
                it.payloadWeights.forEach { payloadWeightsDto ->
                    /**
                     * Important Note: I reused the same tables from the one-to-many relationship example in order
                     * to demonstrate the many-to-many setup.
                     * To avoid confusion, I separated them by creating new entities specifically for this example.
                     * So, All the data from the `payloadWeights` copy to the `payloadWeightsManyToMany` table.
                     * */
                    payloadWeightsDtoManyToManyList.add(
                        PayloadWeightsDtoManyToMany(
                            id = payloadWeightsDto.id,
                            kg = payloadWeightsDto.kg,
                            lb = payloadWeightsDto.lb
                        )
                    )
                    val payloadWeightsEntity: PayloadWeightsEntity =
                        payloadWeightsDto.toPayloadWeightsEntity(rocketId = it.id)
                    myRoomDatabase.payloadWeightDao()
                        .insertOrReplaceObject(data = payloadWeightsEntity)
                }
                if (it.firstStage != null) {
                    myRoomDatabase.firstStageDao()
                        .insertObject(data = it.firstStage.toFirstStageEntity(rocketEntity.id))
                    if (it.firstStage.thrustSeaLevelDto != null) {
                        myRoomDatabase.thrustSeaLevelDao()
                            .insertObject(
                                data = it.firstStage.thrustSeaLevelDto!!.toThrustSeaLevelEntity(
                                    rocketEntity.id
                                )
                            )
                    }
                    if (it.firstStage.thrustVacuumDto != null) {
                        myRoomDatabase.thrustVacuumDao()
                            .insertObject(
                                data = it.firstStage.thrustVacuumDto!!.toThrustVacuumEntity(
                                    rocketEntity.id
                                )
                            )
                    }
                    payloadWeightsDtoManyToManyList.forEach { payloadWeightsDtoManyToMany ->
                        val payloadWeightsEntity: PayloadWeightsManyToManyEntity? =
                            payloadWeightsDtoManyToMany.toPayloadWeightsManyToManyEntity(
                                rocketId = it.id
                            )
                        if (payloadWeightsEntity != null) {
                            myRoomDatabase.payloadWeightManyToManyDao().insert(
                                RocketWithPayloadWeightCrossRef(
                                    id = it.id,
                                    rocketId = payloadWeightsEntity.rocketId
                                )
                            )
                            myRoomDatabase.payloadWeightManyToManyDao()
                                .insert(payloadWeight = payloadWeightsEntity)
                        }
                    }
                }
            }
        }
    }
}
