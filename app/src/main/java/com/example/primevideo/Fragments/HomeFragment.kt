package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.ImageAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Adapters.PopularMoviesAdapter
import com.example.primevideo.Adapters.PopularSeasonAdapter
import com.example.primevideo.Model.LanguageApiHomeFragment.LanguageData
import com.example.primevideo.Model.LanguageApiHomeFragment.LanuguageResponeModel
import com.example.primevideo.Model.Perfect.PerfectResponseModel
import com.example.primevideo.Model.Perfect.PerfectResult
import com.example.primevideo.Model.PopularMoviesModel
import com.example.primevideo.Model.ResultModel
import com.example.primevideo.Model.Shows.Shows
import com.example.primevideo.Model.Shows.ShowsItem
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var listOfPopularMovies: List<ResultModel>
    private lateinit var listOfLanguageData: List<LanguageData>
    private lateinit var listOfPerfectItem: List<PerfectResult>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        PopularMovieApiCall()
        PopularShowApiCall()
        LanguageApiCall()
    }

    private fun imageSliderView() {

        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://www.linkpicture.com/q/1_935.jpg")
        imageList.add("https://www.linkpicture.com/q/2_479.jpg")
        imageList.add("https://www.linkpicture.com/q/3_308.jpg")
        imageList.add("https://www.linkpicture.com/q/4_278.jpg")
        imageList.add("https://www.linkpicture.com/q/5_287.jpg")
        imageList.add("https://www.linkpicture.com/q/6_233.jpg")
        imageList.add("https://www.linkpicture.com/q/7_211.jpg")
        imageList.add("https://www.linkpicture.com/q/8_175.jpg")
        imageList.add("https://www.linkpicture.com/q/9_136.jpg")
        setImageInSlider(imageList, imageSlider = imageSlider)
    }

    private fun setImageInSlider(images: ArrayList<String>, imageSlider: SliderView) {
        val adapter = MySliderImageAdapter()
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }

    private fun PopularMovieApiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getPopularMovie2()
            .enqueue(object : Callback<PopularMoviesModel> {
                override fun onResponse(
                    call: Call<PopularMoviesModel>,
                    response: Response<PopularMoviesModel>
                ) {
                    response.body()?.run {
                        listOfPopularMovies = resultModels
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<PopularMoviesModel>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun setAdapter() {
        var linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularMoviesAdapter = PopularMoviesAdapter(listOfPopularMovies)
        rvPopularMovies.adapter = popularMoviesAdapter
        rvPopularMovies.layoutManager = linearLayoutManager
    }

    private fun PopularShowApiCall() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getPerfectShow().enqueue(object : Callback<PerfectResponseModel> {
            override fun onResponse(
                call: Call<PerfectResponseModel>,
                response: Response<PerfectResponseModel>
            ) {
                response.body()?.run {
                    listOfPerfectItem = perfectResults
                    setAdapterPopularShows()
                }
            }

            override fun onFailure(call: Call<PerfectResponseModel>, t: Throwable) {
                Toast.makeText(
                    context,
                    "Failure in popular show api call" + t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun setAdapterPopularShows() {
        val linearLayoutManager1 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularSeasonAdapter = PopularSeasonAdapter(listOfPerfectItem)
        rvPopularSeason.adapter = popularSeasonAdapter
        rvPopularSeason.layoutManager = linearLayoutManager1
    }


    private fun LanguageApiCall() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getLanguageImage().enqueue(object : Callback<LanuguageResponeModel> {
            override fun onResponse(
                call: Call<LanuguageResponeModel>,
                response: Response<LanuguageResponeModel>
            ) {
                response.body()?.run {
                    listOfLanguageData = languageData
                    setAdapterLanguageImage()

                }
            }

            override fun onFailure(call: Call<LanuguageResponeModel>, t: Throwable) {
                Toast.makeText(context, "Language Api Fragment Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setAdapterLanguageImage() {
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val imageAdapter = ImageAdapter(listOfLanguageData)
        rvWatchYourLanguage.adapter = imageAdapter
        rvWatchYourLanguage.layoutManager = linearLayoutManager
    }
}