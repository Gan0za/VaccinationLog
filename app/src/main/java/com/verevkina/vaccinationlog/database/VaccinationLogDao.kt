package com.verevkina.vaccinationlog.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface VaccinationLogDao {

    @Insert
    fun insertUser(user: UsersEntitie)

    @Update
    fun updateUser(user: UsersEntitie)

    @Query("SELECT * FROM users WHERE id_user = :key")
    fun getUser(key: Long): UsersEntitie?

    @Query("SELECT * FROM users ORDER BY id_user DESC")
    fun getAllUsers(): LiveData<List<UsersEntitie>>

    @Query("SELECT * FROM users ORDER BY id_user DESC LIMIT 1")
    fun getToUser(): UsersEntitie?
}