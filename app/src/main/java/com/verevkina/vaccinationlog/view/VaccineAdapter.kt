package com.verevkina.vaccinationlog.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R
import com.verevkina.vaccinationlog.database.VaccinesEntitie

//Адаптер для списка Вакцин в меню Настроек
class VaccineAdapter: RecyclerView.Adapter<VaccineViewHolder>() {
    var data = listOf<VaccinesEntitie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_item_view_vaccine,
            parent, false)

        return VaccineViewHolder(view)
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.resources
        holder.vaccinationName.text = item.NameVaccine
        if (item.ComponentsVaccine)
            holder.vaccinationComponent.text = "2"
        else
            holder.vaccinationComponent.text = "1"
    }

    override fun getItemCount(): Int {
        return data.size
    }

}