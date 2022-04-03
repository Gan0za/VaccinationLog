package com.verevkina.vaccinationlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.verevkina.vaccinationlog.database.VaccinationDatabase
import com.verevkina.vaccinationlog.databinding.FragmentAddNewTaskBinding
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory
import com.verevkina.vaccinationlog.view.UsersAdapterList
import com.verevkina.vaccinationlog.view.VaccineAdapterList

class AddNewTaskFragment : Fragment() {

    private lateinit var viewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(this.activity).application
        val dao = VaccinationDatabase.getInstance(application).getVaccinationLogDao()
        val viewModelFactory = TrackerViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TrackerViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentAddNewTaskBinding>(
            inflater, R.layout.fragment_add_new_task, container, false)
        val toast_clear_vaccines = resources.getString(R.string.toast_clear_vaccines)
        val duration = Toast.LENGTH_SHORT

        val adapterVaccines = VaccineAdapterList(application)
        val adapterUsers = UsersAdapterList(application)

        binding.vaccinationId.adapter = adapterVaccines
        binding.userId.adapter = adapterUsers
        viewModel.vaccines.observe(viewLifecycleOwner, Observer { vaccines ->
            if (vaccines != null)
                adapterVaccines.dataVaccine = vaccines
        })
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            if (users != null)
                adapterUsers.dataUsers = users
        })

        binding.addNewTasks.setOnClickListener {
            binding.textView2.text = binding.vaccinationId.selectedItemId.toString()
            binding.textView.text = binding.userId.selectedItemId.toString()
//            binding.textView4.text = binding.componentNumber.selectedItemId.toString()
        }

//        binding.userId.setOnClickListener {
//            Toast.makeText(application, binding.userId.selectedItemId.toString(), duration).show()
//        }


        return binding.root
    }
}