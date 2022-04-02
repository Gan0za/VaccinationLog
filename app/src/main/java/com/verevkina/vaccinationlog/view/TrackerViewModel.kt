package com.verevkina.vaccinationlog.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.verevkina.vaccinationlog.database.UsersEntitie
import com.verevkina.vaccinationlog.database.VaccinationLogDao
import com.verevkina.vaccinationlog.parseListUsersDB
import kotlinx.coroutines.*

class TrackerViewModel(
    val dao: VaccinationLogDao,
    application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    //Объявление свойств с данными:
    //Получение списка пользователей
    private val users = dao.getAllUsers()
    val ListUsersDB = Transformations.map(users) { users ->
        parseListUsersDB(users, application.resources)
    }

    //Регистрация нового пользователя
    fun initNewUser(SurnameUser: String, NameUser: String,
                    MiddleNameUser: String, BirthdayUser: String) {
        uiScope.launch {
            val newNight = UsersEntitie(SurnameUser = SurnameUser, NameUser = NameUser,
                MiddleNameUser = MiddleNameUser, BirthdayUser = BirthdayUser)
            insert(newNight)
        }
    }
    private suspend fun insert(user: UsersEntitie) {
        withContext(Dispatchers.IO) {
            dao.insertUser(user)
        }
    }
}