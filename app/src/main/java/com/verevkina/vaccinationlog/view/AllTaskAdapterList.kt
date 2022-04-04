package com.verevkina.vaccinationlog.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R
import com.verevkina.vaccinationlog.database.HistoryEntitieAll

class AllTaskAdapterList: RecyclerView.Adapter<TaskViewHolder>() {
    var data = listOf<HistoryEntitieAll>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.select_tasks_veiw,
            parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.resources
        holder.qualiti_user_surname.text = item.surname_user
        holder.qualiti_user_name.text = item.name_user
        holder.qualiti_user_birthday.text = item.birthday_user
        holder.qualiti_user_vaccine.text = item.name_vaccine
        holder.qualiti_user_component.text = item.components_vaccine.toString()
        holder.qualiti_user_date.text = item.date_vaccine
        holder.qualiti_user_time.text = item.time_vaccine

    }

    override fun getItemCount(): Int {
        return data.size
    }

}