package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.KidsPickYouAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Model.KidsPickYouModel
import com.example.primevideo.Model.KidsPickYouResult
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_kids.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KidsFragment : Fragment(R.layout.fragment_kids) {

    private lateinit var listOfKidsPickYou: List<KidsPickYouResult>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        kidsPickYou()
    }


    private fun imageSliderView() {
        val imageList: ArrayList<String> = ArrayList()
        imageList.add("https://www.linkpicture.com/q/bugdaries.jfif")
        imageList.add("https://www.linkpicture.com/q/bugdaires.png")
        imageList.add("https://www.linkpicture.com/q/kids_1.png ")
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

    private fun kidsPickYou() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getKidsPickYou()
            .enqueue(object : Callback<KidsPickYouModel> {
                override fun onResponse(
                    call: Call<KidsPickYouModel>,
                    response: Response<KidsPickYouModel>
                ) {
                    response.body()?.run {
                        listOfKidsPickYou = kidsPickYouResults
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<KidsPickYouModel>, t: Throwable) {
                    Toast.makeText(context, "Failure" + t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        val kidsPickYouAdapter = KidsPickYouAdapter(listOfKidsPickYou)
        rvKidsPickYou.adapter = kidsPickYouAdapter
        rvKidsPickYou.layoutManager = linearLayoutManager
    }


}