package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentTenElevenBinding

class TenElevenFragment : Fragment() {

    private var _binding: FragmentTenElevenBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<UniversityModel>()
    private val universityAdapter: AdapterUniversity = AdapterUniversity()
    private lateinit var database: FirebaseDatabase
    private val universityList = arrayListOf<UniversityModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTenElevenBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRw()


        database = Firebase.database
        database.getReference("university").addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
             val universityModel = snapshot.getValue(UniversityModel::class.java)
                universityList.add(universityModel!!)
                universityAdapter.updateList(universityList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

           }


    fun setRw() {
        with(binding.recyclerViewHome) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = universityAdapter
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}