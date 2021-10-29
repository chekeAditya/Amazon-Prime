package com.applicationprime.primevideo.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(getSupportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(getSupportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()

    private val mFragmentTopmovie = ArrayList<Fragment>()

    private val mFragmentTopmovieTitle = ArrayList<String>()

    private val mFragmentTitleList = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentList.size
        return mFragmentTopmovie.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
        return mFragmentTopmovie[position]

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
        return  mFragmentTopmovieTitle[position]
    }

    fun addFragment(fragment: Fragment,title : String){
        mFragmentList.add(fragment)
        mFragmentTopmovie.add(fragment)
        mFragmentTopmovieTitle.add(title)
        mFragmentTitleList.add(title)
    }
}