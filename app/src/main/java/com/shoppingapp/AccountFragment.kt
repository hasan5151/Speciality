package com.shoppingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth


        binding.next.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val name = binding.name.text.toString()

            if (email.equals("") || password.equals("") || name.equals("")) {

                Toast.makeText(context, "Punktlar boş ola bilməz", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                    if (auth.currentUser !== null)
                        Log.e("FireBaseUserId","user id: ${auth.currentUser?.uid}")
                    val database = Firebase.database
                    val myRef = database.getReference(auth.currentUser?.uid!!).setValue(name)

                   val action = AccountFragmentDirections.actionAccountFragmentToHomeFragment()
                    Navigation.findNavController(view).navigate(action)

                }.addOnFailureListener {
                    Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}