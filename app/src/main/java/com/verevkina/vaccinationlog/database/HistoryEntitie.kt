package com.verevkina.vaccinationlog.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntitie (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_history")
    var idHistory: Long = 0L,

    @ColumnInfo(name = "user_id")
    var UserId: Long,

    @ColumnInfo(name = "components_vaccine")
    var ComponentsVaccine: Long = 0L,

    @ColumnInfo(name = "date_vaccine")
    var DateVaccine: String,

    @ColumnInfo(name = "time_vaccine")
    var TimeVaccine: String
)