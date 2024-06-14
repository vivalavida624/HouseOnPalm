package com.example.houseonpalm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.houseonpalm.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_brokers, R.id.navigation_favourite, R.id.navigation_calculator, R.id.navigation_more
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.popBackStack(R.id.navigation_home, false)
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_brokers -> {
                    navController.popBackStack(R.id.navigation_brokers, false)
                    navController.navigate(R.id.navigation_brokers)
                    true
                }
                R.id.navigation_favourite -> {
                    navController.popBackStack(R.id.navigation_favourite, false)
                    navController.navigate(R.id.navigation_favourite)
                    true
                }
                R.id.navigation_calculator -> {
                    navController.popBackStack(R.id.navigation_calculator, false)
                    navController.navigate(R.id.navigation_calculator)
                    true
                }
                R.id.navigation_more -> {
                    navController.popBackStack(R.id.navigation_more, false)
                    navController.navigate(R.id.navigation_more)
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
