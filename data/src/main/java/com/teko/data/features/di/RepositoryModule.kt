package com.teko.data.features.di

import com.teko.data.features.auth.AuthRepository
import com.teko.data.features.auth.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun providesAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}