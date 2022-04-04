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
import com.verevkina.vaccinationlog.databinding.FragmentSelectUserBinding
import com.verevkina.vaccinationlog.view.AllTaskAdapterList
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory

class SelectUserFragment : Fragment() {

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

        val binding = DataBindingUtil.inflate<FragmentSelectUserBinding>(
            inflater, R.layout.fragment_select_user, container, false)

        viewModel.listUsersDB.observe(viewLifecycleOwner, Observer { listUsersDB ->
            binding.allUsers.text = listUsersDB
        })

        return binding.root
    }
}