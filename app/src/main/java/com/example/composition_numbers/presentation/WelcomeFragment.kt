package com.example.composition_numbers.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.composition_numbers.R
import com.example.composition_numbers.databinding.FragmentGameBinding
import com.example.composition_numbers.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    private var _binding: FragmentWelcomeBinding?=null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccessibly.setOnClickListener {
            launchChooseLevelFragment()
        }
    }


    private fun launchChooseLevelFragment() {

       findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}