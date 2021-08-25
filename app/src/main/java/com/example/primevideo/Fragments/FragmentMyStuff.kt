package com.example.primevideo.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.primevideo.Activity.SeetingActivity
import com.example.primevideo.R
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