package com.verevkina.vaccinationlog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UsersEntitie::class, VaccinesEntitie::class, HistoryEntitie::class], version = 1, exportSchema = true)
abstract class VaccinationDatabase : RoomDatabase() {
    abstract fun getVaccinationLogDao(): VaccinationLogDao

    companion object {
        @Volatile
        private var INSTANCE: VaccinationDatabase? = null

        fun getInstance(context: Context): VaccinationDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        VaccinationDatabase::class.java, "vaccination_log_db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
/*@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    abstract fun getSleepDatabaseDao(): SleepDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getInstance(context: Context): SleepDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                            SleepDatabase::class.java, "sleep_tracker_db")
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}*/