package com.verevkina.vaccinationlog

import android.content.res.Resources
import android.text.Spanned
import com.verevkina.vaccinationlog.database.UsersEntitie
import android.os.Build
import android.text.Html
import androidx.core.text.HtmlCompat
import com.verevkina.vaccinationlog.database.HistoryEntitie
import com.verevkina.vaccinationlog.database.HistoryEntitieAll
import com.verevkina.vaccinationlog.database.VaccinesEntitie

fun parseListUsersDB(users: List<UsersEntitie>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        users.forEach {
            append("${resources.getString(R.string.surname_window_newuser)}: ${it.SurnameUser}<br>")
            append("${resources.getString(R.string.name_window_newuser)}: ${it.NameUser}<br>")
            append("${resources.getString(R.string.middlename_window_newuser)}: ${it.MiddleNameUser}<br>")
            append("${resources.getString(R.string.text_window_newuser)} ${it.BirthdayUser}<br><br>")

        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun parselistVaccinesDB (vaccines: List<VaccinesEntitie>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        vaccines.forEach {
            append("${resources.getString(R.string.select_header_vaccine)} ${it.NameVaccine}<br>")
            if (it.ComponentsVaccine)
                append("${resources.getString(R.string.select_count_components)} 2<br>")
            else
                append("${resources.getString(R.string.select_count_components)} 1<br>")
        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun parselistTasksDB (vaccines: List<HistoryEntitieAll>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        vaccines.forEach {
            append("${resources.getString(R.string.surname_window_newuser)}: ${it.surname_user}<br>")
            append("${resources.getString(R.string.name_window_newuser)}: ${it.name_user}<br>")
            append("${resources.getString(R.string.text_window_newuser)} ${it.birthday_user}<br>")
            append("${resources.getString(R.string.select_header_vaccine)}: ${it.name_vaccine}<br>")
            append("Компонет: ${it.components_vaccine}<br>")
            append("Дата: ${it.date_vaccine}<br>")
            append("Время: ${it.time_vaccine}<br><br>")

        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}