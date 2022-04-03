package com.verevkina.vaccinationlog.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.verevkina.vaccinationlog.database.UsersEntitie
import com.verevkina.vaccinationlog.database.VaccinationLogDao
import com.verevkina.vaccinationlog.database.VaccinesEntitie
import com.verevkina.vaccinationlog.parseListUsersDB
import com.verevkina.vaccinationlog.parselistVaccinesDB
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
    val users = dao.getAllUsers()
    val listUsersDB = Transformations.map(users) { users ->
        parseListUsersDB(users, application.resources)
    }

    //Регистрация нового пользователя
    fun initNewUser(SurnameUser: String, NameUser: String,
                    MiddleNameUser: String, BirthdayUser: String) {
        uiScope.launch {
            val newUser = UsersEntitie(SurnameUser = SurnameUser, NameUser = NameUser,
                MiddleNameUser = MiddleNameUser, BirthdayUser = BirthdayUser)
            insertUser(newUser)
        }
    }
    private suspend fun insertUser(user: UsersEntitie) {
        withContext(Dispatchers.IO) {
            dao.insertUser(user)
        }
    }

    //Удаление Всех пользоватеей
    fun clearAllUser() {
        uiScope.launch {
            clearAllUserQueries()
        }
    }
    private suspend fun clearAllUserQueries() {
        withContext(Dispatchers.IO) {
            dao.clearUsers()
        }
    }

    //Работа с Vaccine
    //Регистрация новой вакцины
    fun initNewVaccine(NameVaccine: String, ComponentsVaccine: Boolean) {
        uiScope.launch {
            val newVaccine = VaccinesEntitie(NameVaccine = NameVaccine, ComponentsVaccine = ComponentsVaccine)
            insertVaccine(newVaccine)
        }
    }
    private suspend fun insertVaccine(vaccine: VaccinesEntitie) {
        withContext(Dispatchers.IO) {
            dao.insertVaccine(vaccine)
        }
    }

    //Удаление Всех вакцин
    fun clearAllVaccine() {
        uiScope.launch {
            clearAllVaccineQueries()
        }
    }
    private suspend fun clearAllVaccineQueries() {
        withContext(Dispatchers.IO) {
            dao.clearVaccines()
        }
    }

    //Получение списка вакцин
    val vaccines = dao.getAllVaccines()
    val listVaccinesDB = Transformations.map(vaccines) { vaccines ->
        parselistVaccinesDB(vaccines, application.resources)
    }
}