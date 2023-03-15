package com.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentTenElevenBinding

class TenElevenFragment : Fragment() {

    private var _binding: FragmentTenElevenBinding? = null
    private val binding get() = _binding!!
    private val meslekAdapter: AdapterMeslek = AdapterMeslek()
    private lateinit var database: FirebaseDatabase
    private val meslekList = arrayListOf<MeslekModel>()

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
        database.getReference("meslek").addChildEventListener(object : ChildEventListener {

            override fun onChildAdded(dataSnapshot: DataSnapshot, prevChildKey: String?) {
                val meslekModel = dataSnapshot.getValue(MeslekModel::class.java)
                meslekList.add(meslekModel!!)
                meslekAdapter.updateList(meslekList)

            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, prevChildKey: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    fun setRw() {
        with(binding.recyclerViewHome) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = meslekAdapter
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}