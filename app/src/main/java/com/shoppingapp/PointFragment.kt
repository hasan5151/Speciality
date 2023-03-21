package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shoppingapp.databinding.FragmentPointBinding

class PointFragment : Fragment() {

    private var _binding: FragmentPointBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentPointBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            birinci.setOnClickListener {
                val action = PointFragmentDirections.actionPointFragmentToFirstGroupFragment()
                findNavController().navigate(action)
            }
            ikinci.setOnClickListener {
                val action = PointFragmentDirections.actionPointFragmentToSecondGroupFragment()
                findNavController().navigate(action)

            }
            ucuncu.setOnClickListener {
                val action = PointFragmentDirections.actionPointFragmentToThirdGroupFragment()
                findNavController().navigate(action)

            }
            dorduncu.setOnClickListener {
                val action = PointFragmentDirections.actionPointFragmentToFourthGroupFragment()
                findNavController().navigate(action)

            }
            besinci.setOnClickListener {
                val action = PointFragmentDirections.actionPointFragmentToFifthGroupFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}