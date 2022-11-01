package com.example.composition_numbers.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.composition_numbers.R
import com.example.composition_numbers.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {



    private lateinit var binding: FragmentGameFinishedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }


}