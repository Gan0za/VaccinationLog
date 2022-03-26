package com.verevkina.vaccinationlog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.verevkina.vaccinationlog.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(
            inflater, R.layout.fragment_main_menu, container, false)

        binding.infoMenu.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_infoFragment)
        }

        binding.settingsMenu.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_settingsMenuFragment)
        }

        binding.newUser.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_addNewUserFragment)
        }

        binding.newTasks.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_addNewTaskFragment)
        }

        binding.selectAllTasks.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_selectTaskFragment)
        }

        binding.selectAllUser.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainMenuFragment_to_selectUserFragment)
        }

        return binding.root
    }
}