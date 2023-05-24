package com.teko.network

import com.teko.network.features.AuthRemoteSource
import com.teko.network.features.AuthRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn
interface RemoteSourceModule {

    @Binds
    @Singleton
    fun providesAuthRemoteSource(
        authRemoteSource: AuthRemoteSourceImpl
    ): AuthRemoteSource
}
