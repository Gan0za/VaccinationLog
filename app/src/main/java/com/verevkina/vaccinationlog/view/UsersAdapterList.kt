package com.verevkina.vaccinationlog.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.verevkina.vaccinationlog.R
import com.verevkina.vaccinationlog.database.UsersEntitie

//Адаптар для выподающего списка пользователей
class UsersAdapterList(val context: Context?): BaseAdapter() {
    var dataUsers = listOf<UsersEntitie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getCount(): Int {
        return dataUsers.size
    }

    override fun getItem(p0: Int): Any {
        return dataUsers[p0]
    }

    override fun getItemId(p0: Int): Long {
        return dataUsers[p0].idUser
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.vaccine_spinner_viewt,
            p2, false)
        val text: TextView = view.findViewById(R.id.vaccination_adapter)
        text.text = dataUsers[p0].SurnameUser + " " + dataUsers[p0].NameUser
        return view
    }

}
