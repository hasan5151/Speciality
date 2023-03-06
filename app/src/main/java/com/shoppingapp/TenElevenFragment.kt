package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shoppingapp.databinding.FragmentTenElevenBinding

class TenElevenFragment : Fragment() {

   private lateinit var binding : FragmentTenElevenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTenElevenBinding.inflate(inflater)

        return binding.root
    }



}