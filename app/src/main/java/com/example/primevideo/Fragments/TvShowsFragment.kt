package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.DRamaTvShowAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Adapters.TopRatedAdapter
import com.example.primevideo.Model.TVShow.DramaTvShow
import com.example.primevideo.Model.TVShow.TopRatedTvSHow
import com.example.primevideo.Model.TVShow.TvDramaModel
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.Network.OnItemListener
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.primevideo.Model.TVShow.DataTvSHowRated as DataTvSHowRated1

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows), OnItemListener {
    private lateinit var dramaTvShows: List<DramaTvShow>
    private lateinit var dataTvSHowRated: List<DataTvSHowRated1>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        dramaTvSHowFun()
        TopRatedShowsFun()
    }

    private fun TopRatedShowsFun() {
        var apiClient2 =Network.getInstance().create(ApiClient::class.java)
        apiClient2.getTopRatedTvShows().enqueue(object : Callback<TopRatedTvSHow>{
            override fun onResponse(
                call: Call<TopRatedTvSHow>,
                response: Response<TopRatedTvSHow>
            ) {
                response.body()?.run {
                    dataTvSHowRated=response.body()!!.data
                    setTopRatedAdapter()
                }
            }

            override fun onFailure(call: Call<TopRatedTvSHow>, t: Throwable) {
                Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun dramaTvSHowFun() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getDramaTvShow()
            .enqueue(object : Callback<TvDramaModel> {
                override fun onResponse(
                    call: Call<TvDramaModel>,
                    response: Response<TvDramaModel>
                ) {
                    response.body()?.run {
                        dramaTvShows = response.body()!!.data
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<TvDramaModel>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val  dRamaTvShowAdapter = DRamaTvShowAdapter(dramaTvShows, this)
        dramaTvShowRecycler.adapter = dRamaTvShowAdapter
        dramaTvShowRecycler.layoutManager = linearLayoutManager
    }
    private fun setTopRatedAdapter() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val topRatedAdapter=TopRatedAdapter(dataTvSHowRated,this)
        dramaTopRatedRecycler.adapter = topRatedAdapter
        dramaTopRatedRecycler.layoutManager = linearLayoutManager
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



    override fun onTvClicked(dramaTvShow: DramaTvShow, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.tvShowFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle()
        bundle.putString("movieImage", dramaTvShow.image)
        bundle.putString("movieName", dramaTvShow.movieName)
        bundle.putString("moviedescription", dramaTvShow.description)
        bundle.putString("movietime",
            dramaTvShow.timing + "    " + dramaTvShow.year)
        bundle.putString("movierating", dramaTvShow.rating)
        bundle.putString("DirectorImage", dramaTvShow.directorImage)
        bundle.putString("DirectorName", dramaTvShow.director)
        parentFragmentManager.setFragmentResult("Moviename", bundle)
    }



    override fun onTopRatedCLicked(dataTvSHowRated: DataTvSHowRated1, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.tvShowFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle()
        bundle.putString("movieImage", dataTvSHowRated.image)
        bundle.putString("movieName", dataTvSHowRated.movieName)
        bundle.putString("moviedescription", dataTvSHowRated.description)
        bundle.putString("movietime",
            dataTvSHowRated.timing + "    " + dataTvSHowRated.year)
        bundle.putString("movierating", dataTvSHowRated.rating)
        bundle.putString("DirectorImage", dataTvSHowRated.directorImage)
       bundle.putString("DirectorName", dataTvSHowRated.director)
       parentFragmentManager.setFragmentResult("Moviename", bundle)
    }



}