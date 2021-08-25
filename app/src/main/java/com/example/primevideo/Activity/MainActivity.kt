package com.example.primevideo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.primevideo.Adapters.ViewPagerAdapter
import com.example.primevideo.Fragments.*
import com.example.primevideo.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fragmentHomes = FragmentHomes()
    private val fragmentFind = FragmentFind()
    private val fragmentDownloads = FragmentDownloads()
    private val fragmentMyStuff = FragmentMyStuff()
    private val fragmentMovie = MoviesFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationBar(fragmentHomes)
        bottomNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fragmentHomes -> setupBottomNavigationBar(fragmentHomes)
                R.id.fragmentFind -> setupBottomNavigationBar(fragmentFind)
                R.id.fragmentDownloads -> setupBottomNavigationBar(fragmentDownloads)
                R.id.fragmentMyStuff -> setupBottomNavigationBar(fragmentMyStuff)
                R.id.fragmentMovies ->setupBottomNavigationBar(fragmentMovie)
            }
            true
        }
    }

    private fun setupBottomNavigationBar(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}
