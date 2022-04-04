package com.verevkina.vaccinationlog.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R

class TaskViewHolder(imageView: View): RecyclerView.ViewHolder(imageView) {
    val qualiti_task_surname: TextView = imageView.findViewById(R.id.qualiti_task_surname)
    val qualiti_task_name: TextView = imageView.findViewById(R.id.qualiti_task_name)
    val qualiti_task_birthday: TextView = imageView.findViewById(R.id.qualiti_task_birthday)
    val qualiti_task_vaccine: TextView = imageView.findViewById(R.id.qualiti_task_vaccine)
    val qualiti_task_component: TextView = imageView.findViewById(R.id.qualiti_task_component)
    val qualiti_task_date: TextView = imageView.findViewById(R.id.qualiti_task_date)
    val qualiti_task_time: TextView = imageView.findViewById(R.id.qualiti_task_time)
}