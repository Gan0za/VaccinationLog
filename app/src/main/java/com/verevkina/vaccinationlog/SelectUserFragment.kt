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
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.verevkina.vaccinationlog.database.VaccinationDatabase
import com.verevkina.vaccinationlog.databinding.FragmentSelectUserBinding
import com.verevkina.vaccinationlog.view.*

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

        val adapter_user = AllUserAdapterList(object: UserOnClickListner {
            override fun userOnClick(
                id: String,
                SurnameUser: String,
                NameUser: String,
                MiddleNameUser: String,
                BirthdayUser: String
            ) {
                Toast.makeText(application, id, Toast.LENGTH_SHORT).show()
//                Navigation.findNavController().navigate(R.id.action_selectTaskFragment_to_searchUserFragment)
            }
        })
        binding.selectUsers.adapter = adapter_user
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            if (users != null)
                adapter_user.data = users
        })

        return binding.root
    }
}