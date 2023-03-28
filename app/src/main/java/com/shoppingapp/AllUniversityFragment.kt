package com.shoppingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentAllUniversityBinding

class AllUniversityFragment : Fragment() {

    private var _binding : FragmentAllUniversityBinding? = null
    private val binding get() = _binding!!
    private val universityAdapter: AdapterUniversity = AdapterUniversity()
    private lateinit var database: FirebaseDatabase
    private val universityList = arrayListOf<UniversityModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentAllUniversityBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRw()


        database = Firebase.database
        database.getReference("university").addChildEventListener(object : ChildEventListener {

            override fun onChildAdded(dataSnapshot: DataSnapshot, prevChildKey: String?) {
                val universityModel = dataSnapshot.getValue(UniversityModel::class.java)
                universityList.add(universityModel!!)
                universityAdapter.updateList(universityList)
                          }

            override fun onChildChanged(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        universityAdapter.onClickListener {
            val navigate = AllUniversityFragmentDirections.actionAllUniversityFragmentToSpecialtyFragment(it.id)
            findNavController().navigate(navigate)
        }
    }
    fun setRw() {
        with(binding.recyclerViewAllUni) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = universityAdapter
        }

    }

   }