package com.verevkina.vaccinationlog.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface VaccinationLogDao {
    //Работа Users
    @Insert
    fun insertUser(user: UsersEntitie)

    @Update
    fun updateUser(user: UsersEntitie)

    @Query("DELETE FROM users")
    fun clearUsers()

    @Query("SELECT * FROM users WHERE id_user = :key")
    fun getUser(key: Long): UsersEntitie?

    @Query("SELECT * FROM users ORDER BY id_user DESC")
    fun getAllUsers(): LiveData<List<UsersEntitie>>

    @Query("SELECT * FROM users ORDER BY id_user DESC LIMIT 1")
    fun getToUser(): UsersEntitie?

    //Работа с vaccines
    @Insert
    fun insertVaccine(vaccine: VaccinesEntitie)

    @Query("DELETE FROM vaccines")
    fun clearVaccines()

    @Query("SELECT * FROM vaccines WHERE id_vaccine = :key")
    fun getVaccine(key: Long): VaccinesEntitie?

    @Query("SELECT * FROM vaccines ORDER BY id_vaccine DESC")
    fun getAllVaccines(): LiveData<List<VaccinesEntitie>>
}