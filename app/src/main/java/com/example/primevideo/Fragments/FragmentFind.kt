package com.example.primevideo.Fragments

import android.os.Bundle
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
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_display_search_gird.*
import kotlinx.android.synthetic.main.fragment_find.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentFind : Fragment(R.layout.fragment_find) {

    private lateinit var listOfSearchResult: List<SearchResult>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }

    private fun initview(view: View) {
        genresinit(view)
        Langinit(view)
        Mainbutton(view)
        btnSearchMovie.setOnClickListener {
            searchMovieCalling()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.replace(R.id.container, DisplaySearchGirdFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        }
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
        val searchMovieAdapter =  SearchMovieAdapter(listOfSearchResult)
        rvDisplaySearchMovies.adapter = searchMovieAdapter
        rvDisplaySearchMovies.layoutManager = gridLayoutManager
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
            TODO("Not yet implemented fill amazon original fragment")
        })
        MainKids.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, KidsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        })


    }

    private fun Langinit(view: View) {

        bEnglish.setOnClickListener {
            TODO("Not yet implemented")
        }

        bHindi.setOnClickListener {
            TODO("Not yet implemented")
        }

        bTelugu.setOnClickListener {
            TODO("Not yet implemented")
        }

        bTamil.setOnClickListener {
            TODO("Not yet implemented")
        }

        bKannada.setOnClickListener {
            TODO("Not yet implemented")
        }

        bMalayalam.setOnClickListener {
            TODO("Not yet implemented")
        }


    }

    private fun genresinit(view: View) {
        bDrama.setOnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, DramaGridLayout())
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
            TODO("Not yet implemented")
        }

        bThriller.setOnClickListener {
            TODO("Not yet implemented")
        }

        bHorror.setOnClickListener {
            TODO("Not yet implemented")
        }

    }
}


