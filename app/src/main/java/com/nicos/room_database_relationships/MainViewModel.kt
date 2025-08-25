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
            rocketsRepositoryImpl.getRockets().collect {
                withContext(Dispatchers.Main) {
                    it.forEach {
                        Log.d("rockets", it.rocketEntity.rocketName.toString())
                    }
                }
            }
        }
    }
}