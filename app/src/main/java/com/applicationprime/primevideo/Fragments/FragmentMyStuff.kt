package com.applicationprime.primevideo.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.applicationprime.primevideo.Activity.SeetingActivity
import com.applicationprime.primevideo.R
import kotlinx.android.synthetic.main.fragment_my_stuff.*

class FragmentMyStuff : Fragment(R.layout.fragment_my_stuff) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Btntosettings.setOnClickListener {
            val intent = Intent(activity, SeetingActivity::class.java)
            startActivity(intent)
        }
    }
}