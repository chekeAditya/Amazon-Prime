package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_find.*

class FragmentFind : Fragment(R.layout.fragment_find) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview(view)



    }

    private fun initview(view: View) {
        genresinit(view)
        Langinit(view)
    }

    private fun Langinit(view: View) {

        bEnglish.setOnClickListener(View.OnClickListener {

        })

        bHindi.setOnClickListener(View.OnClickListener {

        })

        bTelugu.setOnClickListener(View.OnClickListener {

        })

        bTamil.setOnClickListener(View.OnClickListener {

        })

        bKannada.setOnClickListener(View.OnClickListener {

        })

        bMalayalam.setOnClickListener(View.OnClickListener {

        })



    }

    private fun genresinit(view: View) {
        bDrama.setOnClickListener(View.OnClickListener {

        })

        bAction.setOnClickListener(View.OnClickListener {

        })

        bRomance.setOnClickListener(View.OnClickListener {

        })

        bComedy.setOnClickListener(View.OnClickListener {

        })

        bThriller.setOnClickListener(View.OnClickListener {

        })

        bHorror.setOnClickListener(View.OnClickListener {

        })


    }



}


