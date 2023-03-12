package com.shoppingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.shoppingapp.databinding.FragmentForgetPasswordBinding


class ForgetPasswordFragment : Fragment() {

    private var _binding: FragmentForgetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       _binding = FragmentForgetPasswordBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.gonderBtn.setOnClickListener {
            val email = binding.yenidenMail.text.toString()
            if (email.equals("")) {
                Toast.makeText(context, "Email daxil etmədiniz", Toast.LENGTH_LONG).show()
            } else {
                MaterialAlertDialogBuilder(requireContext()).apply {

                    setMessage("Emailinize yeni kod gonderdik")
                    setPositiveButton("Yaxşı") { dialog, a ->
                        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.e("password", "Mail gonderildi")

                                } else {
                                    Log.e("password", "Gonderilmedi $email")
                                }
                            }

                    }
                }.show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


