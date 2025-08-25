package com.nicos.room_database_relationships.domain.di

import com.nicos.room_database_relationships.domain.network.RocketsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object ApisServiceModule {

    @Provides
    @Singleton
    fun getRocketsService(retrofit: Retrofit): RocketsApi = retrofit.create(RocketsApi::class.java)
}