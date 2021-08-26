package com.example.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.KidsPickYouAdapter
import com.example.primevideo.Adapters.MySliderImageAdapter
import com.example.primevideo.Adapters.kidsandfamilyAdaptor
import com.example.primevideo.Model.Kids.kidsandfamily.Data
import com.example.primevideo.Model.Kids.kidsandfamily.kidsandfamilyModel
import com.example.primevideo.Model.KidsPickYouModel
import com.example.primevideo.Model.KidsPickYouResult
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.Network.OnItemClickListener
import com.example.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_kids.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KidsFragment : Fragment(R.layout.fragment_kids), OnItemClickListener {

    private lateinit var listOfKidsPickYou: List<KidsPickYouResult>
    private lateinit var listofkidsandfamily: List<Data>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        kidsPickYou()
        kidsandfamily()
    }


    private fun kidsandfamily() {

        var apiClient1 = Network.getInstance().create(ApiClient::class.java)
        apiClient1.getkidsandfamily()
            .enqueue(object : Callback<kidsandfamilyModel> {
                override fun onResponse(
                    call: Call<kidsandfamilyModel>,
                    response: Response<kidsandfamilyModel>,
                ) {

                    response.body()?.run {
                        listofkidsandfamily = response.body()!!.data
                        setAdapterkidsandfamily()
                    }
                }

                override fun onFailure(call: Call<kidsandfamilyModel>, t: Throwable) {
                    Toast.makeText(activity, "error" + t.message, Toast.LENGTH_LONG).show()
                }

            })

    }

    private fun setAdapterkidsandfamily() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val kidsandfamilyAdaptor = kidsandfamilyAdaptor(listofkidsandfamily, this)
        rvkidsandfamily.adapter = kidsandfamilyAdaptor
        rvkidsandfamily.layoutManager = linearLayoutManager
    }

    override fun onitemclick(position: Int) {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.kidsFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", listofkidsandfamily[position].image)
        bundle.putString("movieName", listofkidsandfamily[position].movieName)
        bundle.putString("moviedescription", listofkidsandfamily[position].description)
        bundle.putString("movietime", listofkidsandfamily[position].timing+"    "+listofkidsandfamily[position].year)
        bundle.putString("movierating", listofkidsandfamily[position].rating)
        parentFragmentManager.setFragmentResult("Moviename", bundle)

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
                    response: Response<KidsPickYouModel>,
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
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val kidsPickYouAdapter = KidsPickYouAdapter(listOfKidsPickYou)
        rvKidsPickYou.adapter = kidsPickYouAdapter
        rvKidsPickYou.layoutManager = linearLayoutManager
    }

}