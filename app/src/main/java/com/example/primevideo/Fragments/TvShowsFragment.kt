package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.DRamaTvShowAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Model.TVShow.DramaTvShow
import com.example.primevideo.Model.TVShow.TvDramaModel
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows), OnItemClickListener {
    private lateinit var dramaTvShows: List<DramaTvShow>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        dramaTvSHowFun()
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

    override fun onitemclick(position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.tvShowFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", dramaTvShows[position].image)
        bundle.putString("movieName", dramaTvShows[position].movieName)
        bundle.putString("moviedescription", dramaTvShows[position].description)
        bundle.putString("movietime", dramaTvShows[position].timing+"    "+dramaTvShows[position].year)
        bundle.putString("movierating", dramaTvShows[position].rating)
        parentFragmentManager.setFragmentResult("Moviename", bundle)

    }
}