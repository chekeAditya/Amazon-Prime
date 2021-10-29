package com.applicationprime.primevideo.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.bumptech.glide.Glide
import com.applicationprime.primevideo.R
import kotlinx.android.synthetic.main.fragment_movie_preview.*
import com.applicationprime.primevideo.Activity.YoutubeVideoPlayActivity


class MoviePreviewFragment : Fragment(R.layout.fragment_movie_preview) {



    override
    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receivingOperation()
        onClickButton()
        dramaDataFragment()
        ActionDataFragment()
        RomanceDataFragment()
        popularMovie()
        perfectMovie()
        findsection()

    }

    private fun findsection() {

        parentFragmentManager.setFragmentResultListener(
            "FindMovie",
        this,
            FragmentResultListener(){  s: String, bundle: Bundle ->

                val data = bundle.getString("movieimage")
                Glide.with(ivImagePreviewLayout).load(data).into(ivImagePreviewLayout)
                val moviename = bundle.getString("movieName")
                MovieName.text = moviename
                val moviedescription = bundle.getString("moviedescription")
                movieDescriptionPreviewLayout.setText(moviedescription)

            }
        )
    }

    private fun perfectMovie() {
        parentFragmentManager.setFragmentResultListener(
            "Perfectname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data1 = bundle.getString("PerfectImage")
                Glide.with(ivImagePreviewLayout).load(data1).into(ivImagePreviewLayout)
                val moviename1 = bundle.getString("PerfectName")
                MovieName.setText(moviename1)
                val moviedescription1 = bundle.getString("Perfectdescription")
                movieDescriptionPreviewLayout.setText(moviedescription1)
            })
    }

    private fun popularMovie() {
        parentFragmentManager.setFragmentResultListener(
            "Popularname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data1 = bundle.getString("PopularImage")
                Glide.with(ivImagePreviewLayout).load(data1).into(ivImagePreviewLayout)
                val moviename1 = bundle.getString("PopularName")
                MovieName.setText(moviename1)
                val moviedescription1 = bundle.getString("Populardescription")
                movieDescriptionPreviewLayout.setText(moviedescription1)
            })
    }


    private fun onClickButton() {
        lyt_watchlist.setOnClickListener {
            Toast.makeText(context, "Added to the Watchlist", Toast.LENGTH_SHORT).show()
        }
        lyt_download.setOnClickListener{
            Toast.makeText(context, "Added to the Watchlist", Toast.LENGTH_SHORT).show()
        }

    }

    private fun receivingOperation() {
        parentFragmentManager.setFragmentResultListener(
            "Moviename",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data = bundle.getString("movieImage")
                Glide.with(ivImagePreviewLayout).load(data).into(ivImagePreviewLayout)
                val moviename = bundle.getString("movieName")
                MovieName.text = moviename
                val moviedescription = bundle.getString("moviedescription")
                movieDescriptionPreviewLayout.setText(moviedescription)
                val movietime = bundle.getString("movietime")
                year_mat.text = movietime
                val movierating = bundle.getString("movierating")
                movierating.also { rating.text = it }
                val directorImage = bundle.getString("DirectorImage")
                Glide.with(ivDirectorImage).load(directorImage).into(ivDirectorImage)
                val directorName = bundle.getString("DirectorName")
                tvDirectorName.text = directorName
                val movieUrl = bundle.getString("movieUrl")


                lyt_play.setOnClickListener {
                    val intent = Intent(context, YoutubeVideoPlayActivity::class.java)
                    intent.putExtra("movieUrl", movieUrl)
                    startActivity(intent)
                }

                lyt_sharAll.setOnClickListener {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,"Party Time")
                    intent.putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v=$movieUrl")
                    intent.type = "text/plain"
                    startActivity(Intent.createChooser(intent,"Share With Whom You want to watch : "))
                }

            })
    }

    private fun RomanceDataFragment() {
        parentFragmentManager.setFragmentResultListener(
            "Rname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data1 = bundle.getString("romanceImage")
                Glide.with(ivImagePreviewLayout).load(data1).into(ivImagePreviewLayout)
                val moviename1 = bundle.getString("romanceName")
                MovieName.setText(moviename1)
                val moviedescription1 = bundle.getString("romancedescription")
                movieDescriptionPreviewLayout.setText(moviedescription1)
                val movietime1 = bundle.getString("romancetime")
                year_mat.setText(movietime1)
                val movierating1 = bundle.getString("romancerating")
                rating.text = movierating1
                val directorImage = bundle.getString("romanceDirectorImage")
                Glide.with(ivDirectorImage).load(directorImage).into(ivDirectorImage)
                val directorName1 = bundle.getString("romanceDirectorName")
                tvDirectorName.text = directorName1
                val movieUrl = bundle.getString("movieUrl")

                lyt_play.setOnClickListener {
                    val intent = Intent(context, YoutubeVideoPlayActivity::class.java)
                    intent.putExtra("movieUrl", movieUrl)
                    startActivity(intent)
                }
            })
    }

    private fun ActionDataFragment() {
        parentFragmentManager.setFragmentResultListener(
            "Actionname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data1 = bundle.getString("ActionImage")
                Glide.with(ivImagePreviewLayout).load(data1).into(ivImagePreviewLayout)
                val moviename1 = bundle.getString("ActionName")
                MovieName.setText(moviename1)
                val moviedescription1 = bundle.getString("Actiondescription")
                movieDescriptionPreviewLayout.setText(moviedescription1)
                val movietime1 = bundle.getString("Actiontime")
                year_mat.setText(movietime1)
                val movierating1 = bundle.getString("Actionrating")
                rating.text = movierating1
//                val directorImage = bundle.getString("ActionDirectorImage")
//                Glide.with(ivDirectorImage).load(directorImage).into(ivDirectorImage)
                val directorName1 = bundle.getString("ActionDirectorName")
                tvDirectorName.text = directorName1
                val movieUrl = bundle.getString("movieUrl")

                lyt_play.setOnClickListener {
                    val intent = Intent(context, YoutubeVideoPlayActivity::class.java)
                    intent.putExtra("movieUrl", movieUrl)
                    startActivity(intent)
                }
            })
    }

    private fun dramaDataFragment() {
        parentFragmentManager.setFragmentResultListener(
            "Dramaname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                val data1 = bundle.getString("DramaImage")
                Glide.with(ivImagePreviewLayout).load(data1).into(ivImagePreviewLayout)
                val moviename1 = bundle.getString("DramaName")
                MovieName.setText(moviename1)
                val moviedescription1 = bundle.getString("Dramadescription")
                movieDescriptionPreviewLayout.setText(moviedescription1)
                val movietime1 = bundle.getString("Dramatime")
                year_mat.setText(movietime1)
                val movierating1 = bundle.getString("Dramarating")
                rating.text = movierating1
                val directorImage1 = bundle.getString("DramaDirectorImage")
                Glide.with(ivDirectorImage).load(directorImage1).into(ivDirectorImage)
                val directorName1 = bundle.getString("DramaDirectorName")
                tvDirectorName.text = directorName1
                val movieUrl = bundle.getString("movieUrl")

                lyt_play.setOnClickListener {
                    val intent = Intent(context, YoutubeVideoPlayActivity::class.java)
                    intent.putExtra("movieUrl", movieUrl)
                    startActivity(intent)
                }
            })
    }


}