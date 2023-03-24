package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentSpecialtyBinding

class SpecialtyFragment : Fragment() {

    private var _binding : FragmentSpecialtyBinding? = null
    private val binding get() = _binding!!

    val args : SpecialtyFragmentArgs by navArgs()
    val facultyId : Int by lazy { args.id }
    val database by lazy { Firebase.database }
    private val facultyAdapter: AdapterFaculty = AdapterFaculty()
    private val facultyList = arrayListOf<FacultyModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSpecialtyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        database.getReference("faculty").child("$facultyId").addListenerForSingleValueEvent(object:
            ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val defination = snapshot.getValue(FacultyModel::class.java)
                binding.uniId.text = defination?.facultyName
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        setRw()

        database.getReference("faculty").addChildEventListener(object : ChildEventListener {

            override fun onChildAdded(dataSnapshot: DataSnapshot, prevChildKey: String?) {
                val facultyModel = dataSnapshot.getValue(FacultyModel::class.java)
                facultyList.add(facultyModel!!)
                facultyAdapter.updateList(facultyList)
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    fun setRw() {
        with(binding.specRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = facultyAdapter
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


