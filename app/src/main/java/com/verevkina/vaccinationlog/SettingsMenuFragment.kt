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
import com.verevkina.vaccinationlog.databinding.FragmentSettingsMenuBinding
import com.verevkina.vaccinationlog.view.TrackerViewModel
import com.verevkina.vaccinationlog.view.TrackerViewModelFactory
import com.verevkina.vaccinationlog.view.VaccineAdapter

class SettingsMenuFragment : Fragment() {

    private lateinit var viewModel: TrackerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSettingsMenuBinding>(
            inflater, R.layout.fragment_settings_menu, container, false)
        val application = requireNotNull(this.activity).application
        val dao = VaccinationDatabase.getInstance(application).getVaccinationLogDao()
        val viewModelFactory = TrackerViewModelFactory(dao, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TrackerViewModel::class.java)
        val adapter = VaccineAdapter()
        val toast_clear_users = resources.getString(R.string.toast_clear_users)
        val toast_new_vaccines = resources.getString(R.string.toast_new_vaccines)
        val toast_new_vaccines_er = resources.getString(R.string.toast_new_vaccines_er)
        val toast_clear_vaccines = resources.getString(R.string.toast_clear_vaccines)
        val duration = Toast.LENGTH_SHORT


        binding.selectVaccines.adapter = adapter
        viewModel.vaccines.observe(viewLifecycleOwner, Observer { vaccines ->
            if (vaccines != null)
                adapter.data = vaccines
        })

        binding.clearAllUser.setOnClickListener {
            viewModel.clearAllUser()
            Toast.makeText(application, toast_clear_users, duration).show()
        }

        binding.saveNewVaccine.setOnClickListener {
            if (binding.vaccinationName.text.toString() != "") {
                viewModel.initNewVaccine(binding.vaccinationName.text.toString(), binding.vaccinationComponent.isChecked)
                Toast.makeText(application, toast_new_vaccines, duration).show()
            } else
                Toast.makeText(application, toast_new_vaccines_er, duration).show()
        }
        binding.clearAllVaccination.setOnClickListener {
            viewModel.clearAllVaccine()
            Toast.makeText(application, toast_clear_vaccines, duration).show()
        }

        return binding.root
    }
}