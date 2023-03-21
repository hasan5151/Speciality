package com.shoppingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentMeslekDefinitionBinding
import com.squareup.picasso.Picasso

class MeslekDefinition : Fragment() {
    lateinit var binding : FragmentMeslekDefinitionBinding
    val args : MeslekDefinitionArgs by navArgs()
    val meslekId : Int by lazy { args.id }
    val database by lazy { Firebase.database }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeslekDefinitionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database.getReference("meslekdefinations").child("$meslekId").addListenerForSingleValueEvent(object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val defination = snapshot.getValue(MeslekDefinationModel::class.java)
                binding.meslekId.text = defination?.about.toString()
                Picasso.get().load("https://console.firebase.google.com/project/ixtisas-5c890/storage/ixtisas-5c890.appspot.com/files").into(binding.meslekImage);
            }

            override fun onCancelled(error: DatabaseError) {}
        })


    }
}