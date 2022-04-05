package com.verevkina.vaccinationlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.verevkina.vaccinationlog.database.VaccinationDatabase
import com.verevkina.vaccinationlog.databinding.FragmentAddNewUserBinding
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory

class AddNewUserFragment : Fragment() {

    private lateinit var viewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAddNewUserBinding>(
            inflater, R.layout.fragment_add_new_user, container, false)

        val application = requireNotNull(this.activity).application
        val dao = VaccinationDatabase.getInstance(application).getVaccinationLogDao()
        val viewModelFactory = TrackerViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TrackerViewModel::class.java)

        val toast_text = resources.getString(R.string.toast_text)
        val toast_error = resources.getString(R.string.toast_error)
        val duration = Toast.LENGTH_SHORT

        binding.saveNewUser.setOnClickListener {
            if (binding.SurnameUser.text.toString() != "" &&
                binding.NameUser.text.toString() != "" &&
                binding.BirthdayUser.text.toString() != "") {
                viewModel.initNewUser(
                    binding.SurnameUser.text.toString(),
                    binding.NameUser.text.toString(),
                    binding.MiddleNameUser.text.toString(),
                    binding.BirthdayUser.text.toString()
                )
                Toast.makeText(application, toast_text, duration).show() // Сообщение об усп.регистрации
                binding.SurnameUser.text.clear() //Очищаем поля
                binding.NameUser.text.clear()
                binding.MiddleNameUser.text.clear()
                binding.BirthdayUser.text.clear()
            } else {
                Toast.makeText(application, toast_error, duration).show() //Сообщение об ошибке
            }
        }

        return binding.root
    }
}