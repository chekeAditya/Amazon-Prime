package com.applicationprime.primevideo.Fragments.FindView

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationprime.primevideo.Adapters.ActionMovieAdapter
import com.applicationprime.primevideo.Adapters.DramaMovieAdapter
import com.applicationprime.primevideo.Adapters.RomanceMovieAdapter
import com.applicationprime.primevideo.Fragments.MoviePreviewFragment
import com.applicationprime.primevideo.Model.*
import com.applicationprime.primevideo.Network.ApiClient
import com.applicationprime.primevideo.Network.Network
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import kotlinx.android.synthetic.main.item_grid_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DramaGridLayout: Fragment(R.layout.item_grid_layout), OnItemMovieClick {

    private lateinit var listofData: List<DramaDataList>
    private lateinit var listofActionMovieListResponse: List<ActionMovieListResponse>

    private lateinit var listofRomanceData1: List<RomanceData>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        parentFragmentManager.setFragmentResultListener(
            "Dramaname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                itext1.text = bundle.getString("D")
                DramaMovieApiCall()

            })

        parentFragmentManager.setFragmentResultListener(
            "Actionname",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                itext1.text = bundle.getString("A")
                ActionMovieApiCall()

            })

        parentFragmentManager.setFragmentResultListener(
            "Romancename",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->

                itext1.text = bundle.getString("R")
                RomanceMovieApiCall()

            })


    }

    private fun RomanceMovieApiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getRomanticMovies()
            .enqueue(object : Callback<RomanceResponseDTO> {
                override fun onResponse(
                    call: Call<RomanceResponseDTO>,
                    romanceResponse: Response<RomanceResponseDTO>
                ) {
                    romanceResponse.body()?.run {
                        listofRomanceData1 =data!!
                        RomanceMsetAdapter()
                    }

                }
                override fun onFailure(call: Call<RomanceResponseDTO>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }


    private fun RomanceMsetAdapter() {

        val romanceMovieAdapter = RomanceMovieAdapter(listofRomanceData1,this)
        recGrid.adapter = romanceMovieAdapter
        recGrid.layoutManager = GridLayoutManager(activity,2)
    }




    private fun DramaMovieApiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getTOPMovies()
            .enqueue(object : Callback<DramaResponseDTO> {
                override fun onResponse(
                    call: Call<DramaResponseDTO>,
                    dramaResponse: Response<DramaResponseDTO>
                ) {
                    dramaResponse.body()?.run {
                        listofData = data!!
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<DramaResponseDTO>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun setAdapter() {
        var topMovieAdapter = DramaMovieAdapter(listofData,this)
        recGrid.adapter = topMovieAdapter
        recGrid.layoutManager = GridLayoutManager(activity,2)
    }



    private fun ActionMovieApiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getLatestMovies()
            .enqueue(object : Callback<List<ActionMovieListResponse>> {
                override fun onResponse(
                    call: Call<List<ActionMovieListResponse>>,
                    response: Response<List<ActionMovieListResponse>>
                ) {

                    listofActionMovieListResponse = response.body()!!
                    LatestMsetAdapter()

                }
                override fun onFailure(call: Call<List<ActionMovieListResponse>>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun LatestMsetAdapter() {

        var latestMovieAdapter = ActionMovieAdapter(listofActionMovieListResponse,this)
        recGrid.adapter = latestMovieAdapter
        recGrid.layoutManager = GridLayoutManager(activity,2)
    }


    override fun onDramaClick(drama: DramaDataList, position: Int) {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmnentTranscation  = fragmentManager.beginTransaction()
        fragmnentTranscation.replace(R.id.fcContainner,MoviePreviewFragment())
        fragmnentTranscation.addToBackStack(null)
        fragmnentTranscation.commit()



        val bundle = Bundle();
        bundle.putString("DramaImage", drama.image)
        bundle.putString("DramaUrl",drama.movieTrailerLink)
        bundle.putString("DramaName", drama.movieName)
        bundle.putString("Dramadescription", drama.description)
        bundle.putString("Dramatime",
            drama.timing + "    " + drama.year)
        bundle.putString("Dramarating", drama.rating)
        bundle.putString("DramaDirectorImage", drama.directorImage)
        bundle.putString("DramaDirectorName", drama.director)
        parentFragmentManager.setFragmentResult("DramaExtended", bundle)
    }

    override fun onActionClick(action: ActionMovieListResponse, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fcContainner, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("DramaImage", action.image)
        bundle.putString("DramaUrl",action.movieTrailerLink)
        bundle.putString("DramaName", action.movieName)
        bundle.putString("Dramadescription", action.description)
        bundle.putString("DramaDirectorName", action.director)
        parentFragmentManager.setFragmentResult("DramaExtended", bundle)
    }

    override fun onRomanceClick(romance: RomanceData, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.replace(R.id.fcContainner, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("DramaImage", romance.image)
        bundle.putString("DramaUrl",romance.movieTrailerLink)
        bundle.putString("DramaName", romance.movieName)
        bundle.putString("Dramadescription", romance.description)
        bundle.putString("Dramatime",
            romance.timing + "    " + romance.year)
        bundle.putString("Dramarating", romance.rating)
        bundle.putString("DramaDirectorImage", romance.directorImage)
        bundle.putString("DramaDirectorName", romance.director)
        parentFragmentManager.setFragmentResult("DramaExtended", bundle)
    }
}