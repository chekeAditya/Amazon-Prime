package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import com.bumptech.glide.Glide
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_movie_preview.*
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import kotlinx.android.synthetic.main.fragment_tv_shows.tvChecking


class MoviePreviewFragment : Fragment(R.layout.fragment_movie_preview) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener("Moviename",this,  FragmentResultListener(){ s: String, bundle: Bundle ->

            val data = bundle.getString("movieImage")
            Glide.with(ivImagePreviewLayout).load(data).into(ivImagePreviewLayout)
            val moviename = bundle.getString("movieName")
            MovieName.setText(moviename)
            val moviedescription = bundle.getString("moviedescription")
            movieDescriptionPreviewLayout.setText(moviedescription)
            val movietime = bundle.getString("movietime")
            year_mat.setText(movietime)
            val movierating = bundle.getString("movierating")
            rating.setText(movierating)
            val directorImage = bundle.getString("DirectorImage")
            Glide.with(ivDirectorImage).load(directorImage).into(ivDirectorImage)
            val directorName = bundle.getString("DirectorName")
            tvDirectorName.setText(directorName)

        })
    }
}