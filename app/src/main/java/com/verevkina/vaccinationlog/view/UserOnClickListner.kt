package com.verevkina.vaccinationlog.view

interface UserOnClickListner {
    fun userOnClick(id: String, SurnameUser: String, NameUser: String,
                    MiddleNameUser: String, BirthdayUser: String)
}