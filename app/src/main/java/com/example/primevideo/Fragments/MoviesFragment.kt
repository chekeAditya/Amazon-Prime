package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment(R.layout.fragment_movies) {





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()

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
    



}
