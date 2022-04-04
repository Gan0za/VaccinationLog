package com.verevkina.vaccinationlog.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.verevkina.vaccinationlog.R
import com.verevkina.vaccinationlog.database.HistoryEntitieAll
import com.verevkina.vaccinationlog.database.UsersEntitie

class AllUserAdapterList(private val onClickListner: UserOnClickListner): RecyclerView.Adapter<UserViewHolder>() {
    var data = listOf<UsersEntitie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.select_user_veiw,
            parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.resources
        holder.qualiti_user_surname.text = item.SurnameUser
        holder.qualiti_user_name.text = item.NameUser
        holder.qualiti_user_middlename.text = item.MiddleNameUser
        holder.qualiti_user_birthday.text = item.BirthdayUser

        holder.qualiti_user_id.setOnClickListener {
            onClickListner.userOnClick(item.idUser.toString(), item.SurnameUser,
                item.NameUser, item.MiddleNameUser, item.BirthdayUser)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}