package com.verevkina.vaccinationlog

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.verevkina.vaccinationlog.database.UsersEntitie
import com.verevkina.vaccinationlog.database.VaccinationDatabase
import com.verevkina.vaccinationlog.database.VaccinationLogDao
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var vaccinDao: VaccinationLogDao
    private lateinit var db: VaccinationDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, VaccinationDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        vaccinDao = db.getVaccinationLogDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val userTest = UsersEntitie(SurnameUser = "Test", NameUser = "Test", BirthdayUser = "01.01.1001")
        vaccinDao.insertUser(userTest)
        val toUser = vaccinDao.getToUser()
        assertEquals(toUser?.MiddleNameUser, "")
    }
}