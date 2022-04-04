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
import com.verevkina.vaccinationlog.databinding.FragmentMainMenuBinding
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory

class SearchUserFragment : Fragment() {

    private lateinit var viewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAddNewUserBinding>(
            inflater, R.layout.fragment_search_user, container, false)

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
                viewModel.clearAllUser()
                viewModel.initNewUser(
                    binding.SurnameUser.text.toString(),
                    binding.NameUser.text.toString(),
                    binding.MiddleNameUser.text.toString(),
                    binding.BirthdayUser.text.toString()
                )
                Toast.makeText(application, toast_text, duration).show()
                binding.SurnameUser.text.clear()
                binding.NameUser.text.clear()
                binding.MiddleNameUser.text.clear()
                binding.BirthdayUser.text.clear()
            } else {
                Toast.makeText(application, toast_error, duration).show()
            }
        }

        return binding.root
    }
}