package com.teko.local.di

import com.teko.local.AppDatabase
import com.teko.local.DatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(helper: DatabaseHelper): AppDatabase {
        return AppDatabase.createInstance(helper)
    }
}
