package com.shoppingapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shoppingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var auth: FirebaseAuth
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentInMain) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)
        NavigationUI.setupWithNavController(binding.navigationView, navHostFragment.navController)

        binding.bottomNav.setupWithNavController(navHostFragment.navController)
        binding.navigationView.setupWithNavController(navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.e("yoxla", "ok1")
            if (destination.id==R.id.exitFragment){

                    }
                }




        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)

        val baslik = binding.navigationView.inflateHeaderView(R.layout.navigation_title)
        viewModel.name.observe(this) {
            binding.toolbar.subtitle = "Xoş gəldin $it"


            val toggle = ActionBarDrawerToggle(this, binding.drawer, binding.toolbar, 0, 0)
            binding.drawer.addDrawerListener(toggle)
            toggle.syncState()
            if(it!!.isNotEmpty()){
                binding.navigationView.isVisible = true
                Log.e("navView", "true")
            }
            else{ Log.e("navView", "false")
               binding.toolbar.navigationIcon=null
            }

        }

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.exit -> {
                    auth.signOut()
                    navHostFragment.navController.navigate(R.id.loginFragment)
                    binding.drawer.closeDrawer(GravityCompat.START)
                    viewModel.onSetname("")
                                                    }
                R.id.writeUsFragment ->
                {

                        startActivity(
                            Intent(
                                Intent.ACTION_SENDTO,
                                Uri.parse("mailto:aynur.abbaszadehh@gmail.com")
                            )
                        )

                    binding.drawer.closeDrawer(GravityCompat.START)
                }
                R.id.facultyFragment ->
                {
                    navHostFragment.navController.navigate(R.id.facultyFragment)
                    binding.drawer.closeDrawer(GravityCompat.START)
                }

            }
           false
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                    binding.drawer.closeDrawer(GravityCompat.START)

                } else {

                    finish()
                }
            }

        })
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragmentInMain).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

 }