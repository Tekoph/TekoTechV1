package com.teko.local

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {

    companion object {

        // We handle singleton implementation here via dagger, instead of manually handling it.
        fun createInstance(helper: DatabaseHelper): AppDatabase = buildDatabase(helper)

        private fun buildDatabase(helper: DatabaseHelper): AppDatabase {
            val dbName = "tekotech.db"

            return helper.createDatabase(
                name = dbName,
                kClass = AppDatabase::class
            )
        }
    }
}
