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
                "Bakı Dovlət Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                2,
                "Azərbaycan Dövlət Neft və Sənaye Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                3,
                "Azərbaycan Texniki Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                4,
                "Memarlıq və İnşaat Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                5,
                "Azərbaycan Dövlət Pedaqoji Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                6,
                "Azərbaycan Dövlət İqtisad Universiteti"
            )
        )
        addNewUni(UniversityModel(
            7,
            "Bakı Mühəndislik Universiteti"
        ))
        addNewUni(
            UniversityModel(
                8,
                "Azərbaycan Respublikası Prezidenti yanında Dövlət İdarəçilik Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                9,
                "ADA universiteti"
            )
        )
        addNewUni(
            UniversityModel(
            10,
                "Azərbaycan Dövlət Rəssamlıq Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                11,
                "Milli Aviasiya Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                12,
                "Azərbaycan Turizm və Menecment Ubiversiteti"
            )
        )
        addNewUni(
            UniversityModel(
                13,
                "Azərbaycan Dövlət Dəniz Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                14,
                "Bakı Ali Neft Məktəbi"
            )
        )
        addNewUni(
            UniversityModel(
                15,
                "Azərbaycan Respublikasının Dövlət Gömrük Komitəsinin Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                16,
                "Naxçıvan Dövlət Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                17,
                "Azərbaycan Dövlət Aqrar Universiteti (Gəncə şəhəri)"
            )
        )
        addNewUni(
            UniversityModel(
                18,
                "Gəncə Dövlət Univeristeti"
            )
        )
        addNewUni(
            UniversityModel(
                19,
                "Azərcaycan Texnologiya Universiteti(Gəncə şəhəri)"
            )
        )
        addNewUni(
            UniversityModel(
                20,
                "Sumqayıt Dövlət Univeristeti"
            )
        )
        addNewUni(
            UniversityModel(
                21,
                "Mingəçevir Dövlət Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                22,
                "Lənkəran Dövlət Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                23,
                "Azərbaycan Koorperasiya Univeristeti"
            )
        )
        addNewUni(
            UniversityModel(
                24,
                "Azərbaycan Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                25,
                "Qərbi Kaspi Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                26,
                "Xəzər Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                27,
                "Bakı Avrasiya Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                28,
                "Bakı Qızlar Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                29,
                "Naxçıvan Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                30,
                "Azərbaycan Dövlət Mədəniyyət və İncəsənət Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                31,
                "Azərbaycan Dövlət Bədən Tərbiyəsi və İdman Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                32,
                "Odlar Yurdu Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                33,
                "Bakı Biznes Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                34,
                "Azərbaycan Əmək və Sosial Münasibətlər Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                35,
                "Azərbaycan Dillər Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                36,
                "Bakı Slavyan Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                37,
                "Azərbaycan İlahiyyət İnstitutu"
            )
        )
        addNewUni(
            UniversityModel(
                38,
                "Azərbaycan Tibb Universiteti"
            )
        )
        addNewUni(
            UniversityModel(
                39,
                "Bakı Musiqi Akademiyası"
            )
        )
        addNewUni(
            UniversityModel(
                40,
                "Bakı Xoreoqrafiya Akademiyası"
            )
        )

        val faculty = FacultyModel(1,1, "Komputer muhendisliyi", 650.0, 3000, true)
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


        addMeslekDefination(
            MeslekDefinationModel(
                1,
                "Komputer muhendisliyi",
                "Komputer mühəndisliyi - komputerin aparat və program təminatı ilə bağlı ixtisasdır. Daha çox komputerin arxitekturasını, komputer şəbəkələrini, qurğularını, onların iş prinsiplərini öyrənən  sahədir.",
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/hardware%20dev.png?alt=media&token=5d70f2ed-cb8f-4753-9155-0ee5db65cb3d"
            )
        )

        addAllUni(
            PointModel(
                1,
                1,
                1,
                1
            )
        )

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

    fun addNewMeslek(meslek: MeslekModel) {
        database.getReference("meslek").child(meslek.id.toString()).setValue(meslek)
    }

    fun addMeslekDefination(defination: MeslekDefinationModel) {
        database.getReference("meslekdefinations").child(defination.id.toString())
            .setValue(defination)
    }

    fun addAllUni(allUniversity: PointModel) {
        database.getReference("allUni").child(allUniversity.groupId.toString())
            .setValue(allUniversity)

    }


}



