package com.nicos.room_database_relationships.domain.network

import com.nicos.pokedex_compose.domain.network.init_network.MyNetworkManager.Companion.ROCKETS_URL
import com.nicos.room_database_relationships.data.init_database.entities.rockets.RocketsEntity
import retrofit2.http.GET

interface RocketsApi {

    @GET(ROCKETS_URL)
    suspend fun getRockets(): MutableList<RocketsEntity>
}