package com.verevkina.vaccinationlog.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.verevkina.vaccinationlog.database.HistoryEntitie
import com.verevkina.vaccinationlog.database.UsersEntitie
import com.verevkina.vaccinationlog.database.VaccinationLogDao
import com.verevkina.vaccinationlog.database.VaccinesEntitie
import com.verevkina.vaccinationlog.parseListUsersDB
import com.verevkina.vaccinationlog.parselistTasksDB
import com.verevkina.vaccinationlog.parselistVaccinesDB
import kotlinx.coroutines.*

//Полное обращение к БД
class TrackerViewModel(
    val dao: VaccinationLogDao,
    application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    //Работа с пользователями:
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

    fun clearToUser(id: String) {
        uiScope.launch {
            clearToUserQueries(id)
        }
    }
    private suspend fun clearToUserQueries(id: String) {
        withContext(Dispatchers.IO) {
            dao.clearToUsers(id)
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

    fun clearToVaccine(id: String) {
        uiScope.launch {
            clearToVaccineQueries(id)
        }
    }
    private suspend fun clearToVaccineQueries(id: String) {
        withContext(Dispatchers.IO) {
            dao.clearToVaccines(id)
        }
    }

    //Получение списка вакцин
    val vaccines = dao.getAllVaccines()
    val listVaccinesDB = Transformations.map(vaccines) { vaccines ->
        parselistVaccinesDB(vaccines, application.resources)
    }

    //Работа с записями
    //Регистрация новой задачи
    fun initNewTask(UserId: Long, VaccineId: Long, ComponentsVaccine: Long,
                    DateVaccine: String, TimeVaccine: String) {
        uiScope.launch {
            val newTask = HistoryEntitie(UserId = UserId, VaccineId = VaccineId,
                ComponentsVaccine = ComponentsVaccine, DateVaccine = DateVaccine,
                TimeVaccine = TimeVaccine)
            insertTask(newTask)
        }
    }
    private suspend fun insertTask(vaccine: HistoryEntitie) {
        withContext(Dispatchers.IO) {
            dao.insertHistory(vaccine)
        }
    }

    //Удаление Всех записей
    fun clearAllTask() {
        uiScope.launch {
            clearAllTaskQueries()
        }
    }
    private suspend fun clearAllTaskQueries() {
        withContext(Dispatchers.IO) {
            dao.clearHistory()
        }
    }

    fun clearToTask(id: String) {
        uiScope.launch {
            clearToTaskQueries(id)
        }
    }
    private suspend fun clearToTaskQueries(id: String) {
        withContext(Dispatchers.IO) {
            dao.clearToHistory(id)
        }
    }

    //Получение списка записей
    val tasks = dao.getAllHistory()
    val listTasksDB = Transformations.map(tasks) { tasks ->
        parselistTasksDB(tasks, application.resources)
    }
}