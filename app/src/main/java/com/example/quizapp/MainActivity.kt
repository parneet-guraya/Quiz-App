package com.example.quizapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_,destination,_ ->
            if(destination.id == R.id.startFragment || destination.id == R.id.history || destination.id == R.id.profile){
                binding.bottomNavView.visibility = View.VISIBLE
            }else{
                binding.bottomNavView.visibility = View.INVISIBLE
            }
        }
    }
}