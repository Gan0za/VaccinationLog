package com.verevkina.vaccinationlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.verevkina.vaccinationlog.database.VaccinationDatabase
import com.verevkina.vaccinationlog.databinding.FragmentSelectTaskBinding
import com.verevkina.vaccinationlog.view.AllTaskAdapterList
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory

class SelectTaskFragment : Fragment() {

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

        val binding = DataBindingUtil.inflate<FragmentSelectTaskBinding>(
            inflater, R.layout.fragment_select_task, container, false)

        val adapter_task = AllTaskAdapterList()
        binding.selectTasks.adapter = adapter_task
        viewModel.tasks.observe(viewLifecycleOwner, Observer { tasks ->
            if (tasks != null)
                adapter_task.data = tasks
        })

//        viewModel.listTasksDB.observe(viewLifecycleOwner, Observer { listTasksDB ->
//            binding.allTasks.text = listTasksDB
//        })

        return binding.root
    }
}