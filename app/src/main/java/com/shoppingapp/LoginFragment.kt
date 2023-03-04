package com.shoppingapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentHomeBinding
import com.shoppingapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View?{
        _binding = FragmentLoginBinding.inflate(inflater)
        return binding.root

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        binding.signUp.setOnClickListener {
            var action = LoginFragmentDirections.actionLoginFragmentToAccountFragment()
            findNavController(it).navigate(action)
        }

        binding.signIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.parol.text.toString()

            if (email.equals("") || password.equals("")) {
                Toast.makeText(context, "Email və parol daxil edin", Toast.LENGTH_LONG).show()
            } else {
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

                 val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                    findNavController(view).navigate(action)
                }.addOnFailureListener {
                   Toast.makeText(context, it.localizedMessage,Toast.LENGTH_LONG).show()
                }
            }
        }
    }


        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }
    }



