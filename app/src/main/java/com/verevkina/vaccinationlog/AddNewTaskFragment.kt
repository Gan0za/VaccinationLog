package com.verevkina.vaccinationlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.verevkina.vaccinationlog.databinding.FragmentAddNewTaskBinding

class AddNewTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAddNewTaskBinding>(
            inflater, R.layout.fragment_add_new_task, container, false)

        return binding.root
    }
}