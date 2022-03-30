package com.verevkina.vaccinationlog.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccines")
data class VaccinesEntitie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_vaccine")
    var idVaccine: Long = 0L,

    @ColumnInfo(name = "name_vaccine")
    var NameVaccine: String,

    @ColumnInfo(name = "components_vaccine")
    var ComponentsVaccine: Boolean = false
)