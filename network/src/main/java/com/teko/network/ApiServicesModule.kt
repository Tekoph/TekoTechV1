package com.teko.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {

    @Provides
    @Singleton
    fun providesTekoTechApiServices(retrofit: Retrofit): TekoTechApiServices =
        retrofit.create(TekoTechApiServices::class.java)
}
