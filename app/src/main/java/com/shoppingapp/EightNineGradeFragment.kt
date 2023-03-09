package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.shoppingapp.databinding.FragmentEightNineGradeBinding

class EightNineGradeFragment() : Fragment() {
    private lateinit var binding : FragmentEightNineGradeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEightNineGradeBinding.inflate(inflater)

        return binding.root
    }


}