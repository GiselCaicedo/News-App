package com.example.news_app.ui

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.R
import com.example.news_app.databinding.ActivityMainBinding
import com.example.news_app.db.ArticleDatabase
import com.example.news_app.ui.dashboard.DashboardFragment
import com.example.news_app.ui.home.HomeFragment
import com.example.news_app.ui.notifications.NotificationsFragment
import com.example.news_app.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.news_app.repository.NewsRepository

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    private val dashboardFragment = DashboardFragment()
    private val homeFragment = HomeFragment()
    private val notificationFragment = NotificationsFragment()
    private val searchFragment = SearchFragment()

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
                R.id.navigation_search -> {
                    loadFragment(searchFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = MainViewModelProviderFactory(application, newsRepository)
        mainViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)

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
