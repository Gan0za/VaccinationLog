package com.verevkina.vaccinationlog.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R

class UserViewHolder(imageView: View): RecyclerView.ViewHolder(imageView) {
    val qualiti_user_surname: TextView = imageView.findViewById(R.id.qualiti_user_surname)
    val qualiti_user_name: TextView = imageView.findViewById(R.id.qualiti_user_name)
    val qualiti_user_birthday: TextView = imageView.findViewById(R.id.qualiti_user_birthday)
    val qualiti_user_middlename: TextView = imageView.findViewById(R.id.qualiti_user_middlename)

    val qualiti_user_id: LinearLayout = imageView.findViewById(R.id.qualiti_user_id)
}