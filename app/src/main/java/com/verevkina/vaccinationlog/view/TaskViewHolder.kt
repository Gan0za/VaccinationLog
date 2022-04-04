package com.verevkina.vaccinationlog.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R

class TaskViewHolder(imageView: View): RecyclerView.ViewHolder(imageView) {
    val qualiti_user_surname: TextView = imageView.findViewById(R.id.qualiti_user_surname)
    val qualiti_user_name: TextView = imageView.findViewById(R.id.qualiti_user_name)
    val qualiti_user_birthday: TextView = imageView.findViewById(R.id.qualiti_user_birthday)
    val qualiti_user_vaccine: TextView = imageView.findViewById(R.id.qualiti_user_vaccine)
    val qualiti_user_component: TextView = imageView.findViewById(R.id.qualiti_user_component)
    val qualiti_user_date: TextView = imageView.findViewById(R.id.qualiti_user_date)
    val qualiti_user_time: TextView = imageView.findViewById(R.id.qualiti_user_time)
}