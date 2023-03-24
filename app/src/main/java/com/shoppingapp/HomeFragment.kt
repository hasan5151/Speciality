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
                "Bakı Dövlət Universiteti"
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
        addNewUni(
            UniversityModel(
                7,
                "Bakı Mühəndislik Universiteti"
            )
        )
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
                "Azərbaycan Turizm və Menecment Universiteti"
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
                "Gəncə Dövlət Universiteti"
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
                "Sumqayıt Dövlət Universiteti"
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
                "Azərbaycan Koorperasiya Universiteti"
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
                "Komputer mühəndisliyi - komputerin aparat və program təminatı ilə bağlı ixtisasdır. Daha çox komputerin arxitekturasını, komputer şəbəkələrini, qurğularını, onların iş prinsiplərini öyrənən  sahədir. Bu ixtisasın məzunları həm yerli, həm xarici əmək bazarında çox rahatlıqla iş tapa bilirlər.",
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/hardvare.png?alt=media&token=e900e1a5-e4fd-469e-9bda-be6f25317460"
            )
        )

        addMeslekDefination(
            MeslekDefinationModel(
                2,
                "Komputer elmləri",
                "Kompüter elmləri həm kompüter qurğularının, həm də proqram dizaynının öyrənilməsidir. O, həm nəzəri alqoritmlərin öyrənilməsini, həm də onların kompüter avadanlıqları və proqram təminatı vasitəsilə həyata keçirilməsi ilə bağlı praktiki problemləri əhatə edir. Kompüter elmlərinin öyrənilməsi süni intellekt, proqram təminatı mühəndisliyi(software engineering), proqramlaşdırma və kompüter qrafikası da daxil olmaqla bir çox sahəsi vardır. Hazırki dünyamızda kifayət qədər tələbat olan ixtisasdır",
                "https://firebasestorage.googleapis.com/v0/b/ixtisas-5c890.appspot.com/o/dev.png?alt=media&token=ce4a604a-602a-4fc1-8e1a-61cac68d74ec"
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

        addNewFaculty(
            FacultyModel(
                1,
                1,
                "Fizika müəllimliyi",
                389.2,
                389.2,
                2000,
                true

            )
        )
        addNewFaculty(
            FacultyModel(
                2,
                1,
                "Fizika müəllimliyi (tədris ingilis dilində)",
                419.8,
                419.8,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                3,
                1,
                "İnformatika müəllimliyi",
                348.3,
                344.4,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                4,
                1,
                "Riyaziyyat müəllimliyi",
                537.8,
                537.8,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                5,
                1,
                "Riyaziyyat müəllimliyi (tədris ingilis dilində)",
                619.1,
                619.1,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                6,
                1,
                "Fizika",
                328.4,
                328.4,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                7,
                1,
                "Fizika (tədris ingilis dilində)",
                336.4,
                336.4,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                8,
                1,
                "Geologiya",
                256.2,
                256.2,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                9,
                1,
                "Komputer elmləri",
                489.6,
                489.6,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                10,
                1,
                "Komputer elmləri",
                480.5,
                250.0,
                1600,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                11,
                1,
                "Komputer elmləri (tədris ingilis dilində)",
                480.5,
                250.0,
                2000,
                true
            )
        )

        addNewFaculty(
            FacultyModel(
                12,
                1,
                "Mexanika",
                303.4,
                219.8,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                13,
                1,
                "Riyaziyyat",
                375.8,
                375.8,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                14,
                1,
                "Riyaziyyat (tədris ingilis dilində)",
                431.4,
                431.4,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                15,
                1,
                "Geologiya və geofizika mühəndisliyi",
                267.7,
                267.7,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                16,
                1,
                "Geologiya və geofizika mühəndisliyi",
                291.9,
                200.0,
                1600,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                17,
                1,
                "Geologiya və geofizika mühəndisliyi (tədris ingilis dilində)",
                262.5,
                200.0,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                18,
                1,
                "Geomatika və geodeziya mühəndisliyi",
                251.6,
                251.6,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                19,
                1,
                "Geomatika və geodeziya mühəndisliyi",
                0.0,
                200.0,
                1600,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                19,
                1,
                "İnformasiya təhlükəsizliyi",
                545.8,
                545.8,
                2100,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                20,
                1,
                "Kimya mühəndisliyi",
                413.3,
                413.3,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                21,
                1,
                "Mədən mühəndisliyi",
                264.3,
                200.0,
                1900,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                22,
                1,
                "Mühəndis fizikası",
                273.2,
                273.2,
                2000,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                22,
                1,
                "Qida mühəndisliyi",
                327.8,
                327.8,
                2100,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                22,
                1,
                "Qida mühəndisliyi",
                327.8,
                327.8,
                2100,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                23,
                1,
                "Torpaqşunaslıq və aqrokimya",
                266.2,
                266.2,
                2100,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                24,
                1,
                "Torpaqşunaslıq və aqrokimya",
                229.7,
                228.4,
                1700,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                25,
                1,
                "Yer quruluşu və daşınmaz əmlakın kadastrı",
                303.4,
                303.4,
                2100,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                26,
                1,
                "Yer quruluşu və daşınmaz əmlakın kadastrı",
                257.6,
                226.3,
                1700,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                27,
                1,
                "Yer quruluşu və daşınmaz əmlakın kadastrı",
                257.6,
                226.3,
                1700,
                false
            )
        )
        addNewFaculty(
            FacultyModel(
                28,
                1,
                "Fizika müəllimliyi (Qazax filialı)",
                387.3,
                215.1,
                1400,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                29,
                1,
                "İnformatika müəllimliyi (Qazax filialı)",
                356.8,
                203.1,
                1400,
                true
            )
        )
        addNewFaculty(
            FacultyModel(
                30,
                1,
                "Riyaziyyat müəllimliyi (Qazax filialı)",
                498.9,
                244.0,
                1400,
                true
            )
        )
        addNewFaculty(
                FacultyModel(
                    31,
                    1,
                    "Riyaziyyat və informatika müəllimliyi (Qazax filialı)",
                    396.3,
                    291.3,
                    1400,
                    true
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

                    binding . sinif1011 . setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToTenElevenFragment()
                Navigation.findNavController(it).navigate(action)
            }

                    binding . sinif89 . setOnClickListener {
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

    fun addNewFaculty(faculty: FacultyModel) {
        database.getReference("faculty").child(faculty.id.toString())
            .setValue(faculty)
    }


}



