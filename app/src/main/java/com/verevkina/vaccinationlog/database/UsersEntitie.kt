package com.verevkina.vaccinationlog.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntitie (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    var idUser: Long = 0L,

    @ColumnInfo(name = "surname_user")
    var SurnameUser: String,

    @ColumnInfo(name = "name_user")
    var NameUser: String,

    @ColumnInfo(name = "middle_name_user")
    var MiddleNameUser: String = "",

    @ColumnInfo(name = "birthday_user")
    var BirthdayUser: String
)

