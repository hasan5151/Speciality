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

private lateinit var binding : FragmentForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
         binding = FragmentForgetPasswordBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



            binding.gonderBtn.setOnClickListener {
                val email = binding.yenidenMail.text.toString()
                if(email.equals("")){
                    Toast.makeText(context,"Email daxil etmədiniz", Toast.LENGTH_LONG).show()
                }
                else{
                    MaterialAlertDialogBuilder(requireContext()).apply {
                        setTitle("kod")
                        setMessage("Emailinize yeni kod gonderdik")
                        setPositiveButton("ok"){ dialog, a ->
                            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                     Log.e("password", "Mail gonderildi")

                                    } else{
                                        Log.e("password", "Gonderilmedi $email")
                                    }
                                }

                        }
                    }.show()
                }

            }
        }
    }


