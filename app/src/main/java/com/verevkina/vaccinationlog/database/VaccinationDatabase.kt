package com.verevkina.vaccinationlog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UsersEntitie::class, VaccinesEntitie::class, HistoryEntitie::class], version = 2, exportSchema = true)
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
                        VaccinationDatabase::class.java, "vaccination_log_db2")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}