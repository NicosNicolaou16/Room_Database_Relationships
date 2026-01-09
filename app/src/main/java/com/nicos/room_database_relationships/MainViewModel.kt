package com.nicos.room_database_relationships

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicos.room_database_relationships.data.repositoriesImpl.RocketsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val rocketsRepositoryImpl: RocketsRepositoryImpl
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            rocketsRepositoryImpl.getRockets().collect { rocketWithRelationshipsList ->
                withContext(Dispatchers.Main) {
                    rocketWithRelationshipsList.forEach { rocketWithRelationships ->
                        val rocketDetails = """
                            --- Rocket Details ---
                            Rocket Name: ${rocketWithRelationships.rocketEntity.rocketName}
                            Description: ${rocketWithRelationships.rocketEntity.description}
                            Rocket ID: ${rocketWithRelationships.rocketEntity.rocketId}
                            Rocket Type: ${rocketWithRelationships.rocketEntity.rocketType}
                            Active: ${rocketWithRelationships.rocketEntity.active}
                            Stages: ${rocketWithRelationships.rocketEntity.stages}
                            Flickr Images: ${rocketWithRelationships.rocketEntity.flickrImages}
                            Height (meters): ${rocketWithRelationships.heightEntity.meters}
                            First Stage Thrust (Sea Level): ${rocketWithRelationships.firstStageEntity.thrustSeaLevel}
                            First Stage Thrust (Vacuum): ${rocketWithRelationships.firstStageEntity.thrustVacuum}
                        """.trimIndent()
                        Log.d("ROCKET_DATA", rocketDetails)

                        rocketWithRelationships.payloadWeightsEntityList.forEach { payloadWeight ->
                            val payloadDetails =
                                "One-to-Many Payload: id=${payloadWeight.id}, kg=${payloadWeight.kg}, lb=${payloadWeight.lb}"
                            Log.d("ROCKET_DATA_PAYLOAD", payloadDetails)
                        }

                        rocketWithRelationships.payloadWeightsEntityListManyToMany.forEach { payloadWeight ->
                            val payloadDetails =
                                "Many-to-Many Payload: id=${payloadWeight.id}, kg=${payloadWeight.kg}, lb=${payloadWeight.lb}"
                            Log.d("ROCKET_DATA_PAYLOAD", payloadDetails)
                        }
                    }
                }
            }
        }
    }
}