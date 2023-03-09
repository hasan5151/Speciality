package com.shoppingapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.shoppingapp.databinding.FragmentExitBinding


class ExitFragment : Fragment() {

    private lateinit var binding: FragmentExitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MaterialAlertDialogBuilder(requireContext()).apply {
            setTitle("Çıxışa hazırlaşırıq...")
            setMessage("Əminsənmi?")
            setNegativeButton("Xeyr") { dialog, a ->
                val action = ExitFragmentDirections.actionExitFragmentToHomeFragment()
                findNavController().navigate(action)
            }
            setPositiveButton("bəli") { dialog, a ->
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }.show()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentExitBinding.inflate(inflater)
        return binding.root
    }

}




