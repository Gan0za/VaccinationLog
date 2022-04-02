package com.verevkina.vaccinationlog

import android.content.res.Resources
import android.text.Spanned
import com.verevkina.vaccinationlog.database.UsersEntitie
import android.os.Build
import android.text.Html
import androidx.core.text.HtmlCompat

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