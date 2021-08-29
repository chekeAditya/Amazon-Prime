package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.primevideo.Adapters.ViewPagerAdapter
import com.example.primevideo.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_homes.*

class FragmentHomes : Fragment(R.layout.fragment_homes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerAdapter()

    }

    //viewPagerAdapter
    private fun setViewPagerAdapter() {
        val viewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager = parentFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(TvShowsFragment(), "TV Shows")
        viewPagerAdapter.addFragment(MoviesFragment(), "Movies")
        viewPagerAdapter.addFragment(KidsFragment(), "Kids")
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }





}
