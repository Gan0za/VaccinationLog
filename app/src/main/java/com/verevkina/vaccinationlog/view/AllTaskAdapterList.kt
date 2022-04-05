package com.verevkina.vaccinationlog.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R
import com.verevkina.vaccinationlog.database.HistoryEntitieAll

//Адаптер для списка всех привитых
//
class AllTaskAdapterList(private val onClickListner: TaskOnClickListner): RecyclerView.Adapter<TaskViewHolder>() {
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
        holder.qualiti_task_surname.text = item.surname_user
        holder.qualiti_task_name.text = item.name_user
        holder.qualiti_task_birthday.text = item.birthday_user
        holder.qualiti_task_vaccine.text = item.name_vaccine
        holder.qualiti_task_component.text = item.components_vaccine.toString()
        holder.qualiti_task_date.text = item.date_vaccine
        holder.qualiti_task_time.text = item.time_vaccine

        holder.qualiti_task_id.setOnClickListener {
            onClickListner.taskOnClick (item.id_history.toString())
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}