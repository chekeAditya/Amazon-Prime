package com.example.primevideo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.primevideo.Adapters.ViewPagerAdapter
import com.example.primevideo.Fragments.HomeFragment
import com.example.primevideo.Fragments.KidsFragment
import com.example.primevideo.Fragments.MoviesFragment
import com.example.primevideo.Fragments.TvShowsFragment
import com.example.primevideo.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewPagerAdapter()
    }

    //viewPagerAdapter
    private fun setViewPagerAdapter() {
       var viewPager = findViewById<ViewPager>(R.id.viewPager)
       var tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(),"Home")
        viewPagerAdapter.addFragment(TvShowsFragment(),"TV Shows")
        viewPagerAdapter.addFragment(MoviesFragment(),"Movies")
        viewPagerAdapter.addFragment(KidsFragment(),"Kids")
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }
}
