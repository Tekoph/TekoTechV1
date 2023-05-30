package com.teko.local.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.teko.tekotechv1.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return if (BuildConfig.DEBUG) {
            application.getSharedPreferences(
                getDefaultPreferencesName(application),
                Context.MODE_PRIVATE
            )
        } else {
            val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            EncryptedSharedPreferences
                .create(
                    getDefaultPreferencesName(application),
                    masterKeyAlias,
                    application,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        }
    }

    private fun getDefaultPreferencesName(application: Application): String {
        return application.packageName + "_prefs"
    }
}
