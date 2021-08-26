package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.ActionMovieAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Adapters.DramaMovieAdapter
import com.example.primevideo.Adapters.RomanceMovieAdapter
import com.example.primevideo.Model.*
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var listofData: List<DramaDataList>
    private lateinit var listofActionMovieListResponse: List<ActionMovieListResponse>

    private lateinit var listofRomanceData1: List<RomanceData>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        LatestMovieApiCall()
        TopMovieApiCall()
        RomanceMovieApiCall()
    }


    private fun imageSliderView() {
        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://www.linkpicture.com/q/bugdaries.jfif")
        imageList.add("https://www.linkpicture.com/q/bugdaires.png")
        imageList.add("https://www.linkpicture.com/q/kids_1.png")
        imageList.add("https://www.linkpicture.com/q/kids.jpeg")
        imageList.add("https://www.linkpicture.com/q/kids_3.jpg")
        imageList.add("https://www.linkpicture.com/q/kids_4.jpg")
        imageList.add("https://www.linkpicture.com/q/kids_5.jpg")
        imageList.add("https://www.linkpicture.com/q/kids_6.jpg")
        imageList.add("https://www.linkpicture.com/q/kids_7.jpg")
        setImageInSlider(imageList, imageSlider = imageSlider)
    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }

    private fun TopMovieApiCall() {

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
        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        var topMovieAdapter = DramaMovieAdapter(listofData)
        ivTopMrecycler.adapter = topMovieAdapter
        ivTopMrecycler.layoutManager = linearLayoutManager
    }


    private fun LatestMovieApiCall() {

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
        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        var latestMovieAdapter = ActionMovieAdapter(listofActionMovieListResponse)
        ivTlatestMovierecycler.adapter = latestMovieAdapter
        ivTlatestMovierecycler.layoutManager = linearLayoutManager
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
        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        var romanceMovieAdapter = RomanceMovieAdapter(listofRomanceData1)
       ivRomanticMovierecycler.adapter = romanceMovieAdapter
       ivRomanticMovierecycler.layoutManager = linearLayoutManager
    }









}
