package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shoppingapp.databinding.FragmentTenElevenBinding

class TenElevenFragment : Fragment() {

   private var _binding : FragmentTenElevenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       _binding = FragmentTenElevenBinding.inflate(inflater)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}