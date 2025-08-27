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
            rocketsRepositoryImpl.getRockets().collect { rocketWIthRelationships ->
                withContext(Dispatchers.Main) {
                    rocketWIthRelationships.forEach {
                        Log.d("rockets", it.rocketEntity.rocketName.toString())
                        Log.d("rockets", it.rocketEntity.description.toString())
                        Log.d("rockets", it.rocketEntity.rocketId.toString())
                        Log.d("rockets", it.rocketEntity.rocketType.toString())
                        Log.d("rockets", it.rocketEntity.active.toString())
                        Log.d("rockets", it.rocketEntity.stages.toString())
                        Log.d("rockets", it.rocketEntity.flickrImages.toString())
                        it.payloadWeightsEntityList.forEach { payloadWeightsEntity ->
                            Log.d("rockets", payloadWeightsEntity.id.toString())
                            Log.d("rockets", payloadWeightsEntity.kg.toString())
                            Log.d("rockets", payloadWeightsEntity.lb.toString())
                        }
                        Log.d("rockets", it.firstStageEntity.thrustSeaLevel.toString())
                        Log.d("rockets", it.firstStageEntity.thrustVacuum.toString())
                        Log.d("rockets", it.heightEntity.meters.toString())
                    }
                }
            }
        }
    }
}