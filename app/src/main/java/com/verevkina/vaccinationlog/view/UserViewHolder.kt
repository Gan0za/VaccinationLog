package com.verevkina.vaccinationlog.view

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val qualiti_user_surname: TextView = view.findViewById(R.id.qualiti_user_surname)
    val qualiti_user_name: TextView = view.findViewById(R.id.qualiti_user_name)
    val qualiti_user_birthday: TextView = view.findViewById(R.id.qualiti_user_birthday)
    val qualiti_user_middlename: TextView = view.findViewById(R.id.qualiti_user_middlename)

    val qualiti_user_id: Button = view.findViewById(R.id.qualiti_user_id)
}