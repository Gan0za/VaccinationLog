package com.verevkina.vaccinationlog.database

data class HistoryEntitieAll (
    val id_history: Long,
    val surname_user: String,
    val name_user: String,
    val birthday_user: String,
    val name_vaccine: String,
    val components_vaccine: Long,
    val date_vaccine: String,
    val time_vaccine: String,

    )
