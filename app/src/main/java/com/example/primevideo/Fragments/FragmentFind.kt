package com.example.primevideo.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.primevideo.Adapters.PopularShowsAdapter
import com.example.primevideo.Adapters.SearchMovieAdapter
import com.example.primevideo.Fragments.FindView.DramaGridLayout
import com.example.primevideo.Model.PopularShows.PopularShowsModelItem
import com.example.primevideo.Model.SearchFragmentModel.SearchModelFindFragment
import com.example.primevideo.Model.SearchFragmentModel.SearchResult
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.Network.SearchClickListener
import com.example.primevideo.R
import gen._base._base_java__rjava_resources.srcjar.R.id.text
import kotlinx.android.synthetic.main.fragment_display_search_gird.*
import kotlinx.android.synthetic.main.fragment_find.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FragmentFind : Fragment(R.layout.fragment_find) , SearchClickListener {

    private lateinit var listOfSearchResult: List<SearchResult>
    private val RQ_SPEECH_REC = 102
    private lateinit var searchMovieName: String



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }

    private fun initview(view: View) {
        genresinit(view)
        Langinit(view)
        Mainbutton(view)

        btnSearchByMic.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Search By Voice")
            startActivityForResult(intent, RQ_SPEECH_REC)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            searchMovieName = result?.get(0).toString()
            etSearchMovie.setText(searchMovieName)
        }
        searchMovieCalling()
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.replace(R.id.container, DisplaySearchGirdFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()
    }

    private fun searchMovieCalling() {
        val apiClient = Network.getInstanceSearch().create(ApiClient::class.java)
        apiClient.getSearchedMovie(
            "2147294b386ecadcb05cd19bcbbdddb9",
            etSearchMovie.text.toString()
        ).enqueue(object : Callback<SearchModelFindFragment> {
            override fun onResponse(
                call: Call<SearchModelFindFragment>,
                response: Response<SearchModelFindFragment>
            ) {
                response.body()?.run {
                    listOfSearchResult = searchResults
                    setSearchAdapter()

                }
            }

            override fun onFailure(call: Call<SearchModelFindFragment>, t: Throwable) {
                Toast.makeText(context, "Error in Find Search Fragment", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setSearchAdapter() {
        val gridLayoutManager = GridLayoutManager(context, 2)
        val searchMovieAdapter = SearchMovieAdapter(listOfSearchResult,this)
        rvDisplaySearchMovies.adapter = searchMovieAdapter
        rvDisplaySearchMovies.layoutManager = gridLayoutManager
    }

    override fun onSearchItemClicked(searchResult: SearchResult, position: Int) {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.replace(R.id.container, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle()
        bundle.putString("movieimage","https://image.tmdb.org/t/p/w500"+listOfSearchResult[position].posterPath)
        bundle.putString("moviename",listOfSearchResult[position].title)
        bundle.putString("movielanguage",listOfSearchResult[position].originalLanguage)
        bundle.putString("moviedescription",listOfSearchResult[position].overview)
        parentFragmentManager.setFragmentResult("FindMovie", bundle)



    }
    private fun Mainbutton(view: View) {
        MainMovie.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, MoviesFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        }
        MainTv.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, TvShowsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        }
        MainOriginal.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, TvShowsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        })
        MainKids.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, KidsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        }


    }

    private fun Langinit(view: View) {

        bEnglish.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bHindi.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bTelugu.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bTamil.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bKannada.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bMalayalam.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }


    }

    private fun genresinit(view: View) {
        bDrama.setOnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.replace(R.id.container, DramaGridLayout())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
            val bundle = Bundle();
            bundle.putString("D", "Drama")
            parentFragmentManager.setFragmentResult("Dramaname", bundle)

        }

        bAction.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, DramaGridLayout())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
            val bundle = Bundle();
            bundle.putString("A", "Action")
            parentFragmentManager.setFragmentResult("Actionname", bundle)

        }

        bRomance.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, DramaGridLayout())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()

            val bundle = Bundle();
            bundle.putString("R", "Romance")
            parentFragmentManager.setFragmentResult("Romancename", bundle)

        }

        bComedy.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bThriller.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

        bHorror.setOnClickListener {
            Toast.makeText(context, "Available Soon", Toast.LENGTH_SHORT).show()
        }

    }

}


