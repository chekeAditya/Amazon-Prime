package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_movie_preview.*
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import kotlinx.android.synthetic.main.fragment_tv_shows.tvChecking


class MoviePreviewFragment : Fragment(R.layout.fragment_movie_preview) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener("Moviename",this,  FragmentResultListener(){ s: String, bundle: Bundle ->

            val data = bundle.getInt("movieName")
            MovieName.setText(data)
        })
    }
}