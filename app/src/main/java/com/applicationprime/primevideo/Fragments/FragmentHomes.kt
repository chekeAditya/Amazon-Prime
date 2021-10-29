package com.applicationprime.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.applicationprime.primevideo.Adapters.ViewPagerAdapter
import com.applicationprime.primevideo.R
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
