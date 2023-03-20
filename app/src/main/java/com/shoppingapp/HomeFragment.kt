package com.shoppingapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = Firebase.database

        addNewUni(
            UniversityModel(
                1,
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/bdulogo.png?alt=media&token=abebbd67-5a17-4fc8-90cc-0a835b9c37b2",
                "Bakı Dovlət Universiteti"
            )
        )

        addNewUni(
            UniversityModel(
                2,
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/adnsu.png?alt=media&token=f22ed01a-ada2-482c-8512-56af2bde5387",
                "Azərbaycan Dövlət Neft və Sənaye Universiteti"))

          addNewUni(
              UniversityModel(3,
                  "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/unec.png?alt=media&token=e9e5997f-8ce3-4072-ac0c-2adcc6dbf2bd",
                  "Azərbaycan Dövlət Iqtisad Universiteti"))

        addNewUni(
            UniversityModel(
                4,
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/tibb%20png.jpg?alt=media&token=9d3c4e2b-d432-402f-8725-ccc85b5194c7",
                "Azərbaycan Tibb Universiteti"
            )
        )

        addNewUni(UniversityModel(
            5,
            "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/aztu.png?alt=media&token=e15e6c94-959e-4bfd-92dc-ea4153aae23a",
            "Azərbaycan Texniki Universiteti"))

        addNewUni(UniversityModel(
            6,
            "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/memarliq.png?alt=media&token=db550586-5b18-43a5-b9a7-7d396223cefd",
            "Azərbaycan Memarlıq və İnşaat Universiteti"))


        val faculty = FacultyModel(1, 1, "Komputer muhendisliyi", 650.0, 3000, true)
        database.getReference("faculty").child(faculty.id.toString()).setValue(faculty)

        addNewMeslek(MeslekModel(1, "Komputer mühəndisliyi"))
        addNewMeslek(MeslekModel(2, "Komputer elmləri"))
        addNewMeslek(MeslekModel(3, "İnformasiya təhlükəsizliyi"))
        addNewMeslek(MeslekModel(4, "Mexanika"))
        addNewMeslek(MeslekModel(5, "Geologiya və geofizika mühəndisliyi"))
        addNewMeslek(MeslekModel(6, "Geomatika və geodeziya mühəndisliyi"))
        addNewMeslek(MeslekModel(7, "Kimya mühəndisliyi"))
        addNewMeslek(MeslekModel(8, "Mədən mühəndisliyi"))
        addNewMeslek(MeslekModel(9, "Qida mühəndisliyi"))
        addNewMeslek(MeslekModel(10, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(11, "Torpaqşunaslıq və aqrokimya"))
        addNewMeslek(MeslekModel(12, "Yer quruluşu və daşınmaz əmlakın kadastrı"))
        addNewMeslek(MeslekModel(13, "Cihaz mühəndisliyi"))
        addNewMeslek(MeslekModel(14, "Ekologiya mühəndisliyi"))
        addNewMeslek(MeslekModel(15, "Elektrik və elektronika mühəndisliyi"))
        addNewMeslek(MeslekModel(16, "Həyat fəaliyyətinin təhlükəsizliyi mühəndisi"))
        addNewMeslek(MeslekModel(17, "İnformasiya texnologiyaları"))
        addNewMeslek(MeslekModel(18, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(19, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(20, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(21, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(22, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(23, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(24, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(25, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(26, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(27, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(28, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(29, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(30, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(31, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(32, "Mühəndis fizikası"))
        addNewMeslek(MeslekModel(33, "Mühəndis fizikası"))


        addMeslekDefinitoin(MeslekDefinationModel(1,"Komputer muhendisliyi", "dsvcvsdfvdsgvfsdfv"))


        auth = Firebase.auth
        if (auth.currentUser !== null) {
            database.getReference(auth.currentUser?.uid!!)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        viewModel.onSetname("${snapshot.value}")
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
        }

        binding.sinif1011.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTenElevenFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.sinif89.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEightNineGradeFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun addNewUni(university: UniversityModel) {
        database.getReference("university").child(university.id.toString()).setValue(university)
    }
    fun addNewMeslek(meslek : MeslekModel){
        database.getReference("meslek").child(meslek.id.toString()).setValue(meslek)
    }

    fun addMeslekDefinitoin(definition: MeslekDefinationModel){
        database.getReference("meslekdefinitions").child(definition.id.toString()).setValue(definition)

    }


}



