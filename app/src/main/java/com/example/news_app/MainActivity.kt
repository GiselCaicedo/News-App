package com.example.news_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.news_app.databinding.ActivityMainBinding
import com.example.news_app.ui.dashboard.DashboardFragment
import com.example.news_app.ui.home.HomeFragment
import com.example.news_app.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dashboardFragment = DashboardFragment()
    private val homeFragment = HomeFragment()
    private val notificationFragment = NotificationsFragment()

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    loadFragment(dashboardFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    loadFragment(notificationFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigation: BottomNavigationView = findViewById(R.id.bar_navigate_menu)
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        loadFragment(homeFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}
