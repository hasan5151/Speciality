package com.shoppingapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.collection.arraySetOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentFirstGroupBinding
import kotlinx.coroutines.delay


class FirstGroupFragment : Fragment() {
    private lateinit var binding : FragmentFirstGroupBinding
    private val universityAdapter: AdapterUniversity = AdapterUniversity()
    private lateinit var database: FirebaseDatabase
    private val universityList = arrayListOf<UniversityModel>()
    private var point : Double = 0.0
    private val uniIdList  = arraySetOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstGroupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    setRw()
        database = Firebase.database
     binding.enterBtn.setOnClickListener {

         try {
             point = binding.yourPoint.text.toString().toDouble()
             universityList.clear()
             database.getReference("faculty").orderByChild("nonDsPoint").startAt(point)
                 .addChildEventListener(object : ChildEventListener {
                     override fun onChildAdded(dataSnapshot: DataSnapshot, prevChildKey: String?) {
                         val facultyModel  = dataSnapshot.getValue<FacultyModel>()
                         if (facultyModel != null) {
                             if(!uniIdList.contains(facultyModel.uniId)){
                                 uniIdList.add(facultyModel.uniId!!)
                             }
                         }
                     }

                     override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                     }

                     override fun onChildRemoved(snapshot: DataSnapshot) {
                     }

                     override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                     }

                     override fun onCancelled(error: DatabaseError) {
                     }
                 })

             Handler(Looper.getMainLooper()).postDelayed({
                 getUniversity()
             },1000)


         }
         catch (e:java.lang.NumberFormatException){
             e.printStackTrace()
         }

             }



    universityAdapter.onClickListener {
       // val navigate = FirstGroupFragmentDirections
      //  findNavController().navigate(navigate)
    }
}
fun setRw() {
    with(binding.FirstGroupRecyclerView) {
        layoutManager = LinearLayoutManager(requireContext())
        setHasFixedSize(true)
        adapter = universityAdapter
    }

}
    fun getUniversity(){
/*
        uniIdList.distinct().forEach {
            Log.d("uniList","$it")
        }
*/

        uniIdList.forEach {
            database.getReference("university").child(it.toString()).addListenerForSingleValueEvent(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val universityModel = snapshot.getValue<UniversityModel>()
                    if (universityModel != null) {
                        universityList.add(universityModel)
                    }

                    universityAdapter.updateList(universityList)


                }

                override fun onCancelled(error: DatabaseError) {

                }

            } )
        }
    }

}