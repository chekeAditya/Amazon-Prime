package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Adapters.PopularMoviesAdapter
import com.example.primevideo.Model.PopularMoviesModel
import com.example.primevideo.Model.ResultModel
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var listOfPopularMovies: List<ResultModel>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        PopularMovieApiCall()
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
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val popularMoviesAdapter = PopularMoviesAdapter(listOfPopularMovies)
        rvTopMovies.adapter = popularMoviesAdapter
        rvTopMovies.layoutManager = linearLayoutManager
    }

}
