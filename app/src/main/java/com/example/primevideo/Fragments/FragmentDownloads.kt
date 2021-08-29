package com.example.primevideo.Fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_downloads.*

class FragmentDownloads : Fragment(R.layout.fragment_downloads) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                btnRemove.setOnClickListener {
                emptyBox.isInvisible=false
                    layout.isVisible=false
                    movieIv.isVisible=false
                    tvName.isVisible=false
                    tvTime.isVisible=false
                    tvprime.isVisible=false
                    btnRemove.isVisible=false
            }


    }
}