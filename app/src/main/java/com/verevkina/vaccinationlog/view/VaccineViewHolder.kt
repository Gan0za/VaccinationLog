package com.verevkina.vaccinationlog.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R

class VaccineViewHolder(imageView: View): RecyclerView.ViewHolder(imageView) {
    val vaccinationName: TextView = imageView.findViewById(R.id.qualiti_vaccination_name)
    val vaccinationComponent: TextView = imageView.findViewById(R.id.qualiti_vaccination_component)
}