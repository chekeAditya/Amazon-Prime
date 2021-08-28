package com.example.primevideo.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.*
import com.example.primevideo.Model.Kids.kidsandfamily.*
import com.example.primevideo.Model.KidsPickYouModel
import com.example.primevideo.Model.KidsPickYouResult
import com.example.primevideo.Model.TVShow.DataTvSHowRated
import com.example.primevideo.Model.TVShow.DramaTvShow
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
    private lateinit var dataX: List<DataX>
    private lateinit var indianToon: List<IndianToon>
    private lateinit var amazonOriginalKid: List<AmazonOriginalKid>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        kidsPickYou()
        kidsandfamily()
        kidsTv()
        InidanToons()
        AmazonOriginal()



        tvkidsandfamily.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.replace(R.id.kidsFragment, kidsandexpand())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()

            val bundle = Bundle()
            parentFragmentManager.setFragmentResult("kidsandfamilytv", bundle)

        }
    }

    private fun AmazonOriginal() {

        val apiClient4 = Network.getInstance().create(ApiClient::class.java)
        apiClient4.getAmazonorginal().enqueue(object : Callback<AmazonOriginalKids> {
            override fun onResponse(
                call: Call<AmazonOriginalKids>,
                response: Response<AmazonOriginalKids>,
            ) {
                response.body()?.run {
                    amazonOriginalKid = response.body()!!.amazonOriginalKids
                    setAmazonAdaptor()
                }
            }

            override fun onFailure(call: Call<AmazonOriginalKids>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setAmazonAdaptor() {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = AmazonOrigingalAdaptor(amazonOriginalKid, this)
        rvAmazonorginal.adapter = adapter
        rvAmazonorginal.layoutManager = linearLayoutManager
    }

    private fun InidanToons() {

        val apiClient4 = Network.getInstance().create(ApiClient::class.java)
        apiClient4.getInidanToons().enqueue(
            object : Callback<IndianToonsModel> {
                override fun onResponse(
                    call: Call<IndianToonsModel>,
                    response: Response<IndianToonsModel>,
                ) {
                    response.body()?.run {
                        indianToon = response.body()!!.indianToons
                        setInidanToonsRecycler()
                    }
                }

                override fun onFailure(call: Call<IndianToonsModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

    private fun setInidanToonsRecycler() {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val indianToon = InidanToonsAdaptor(indianToon, this)
        rvIndianToons.adapter = indianToon
        rvIndianToons.layoutManager = linearLayoutManager
    }

    private fun kidsTv() {
        var apiClient3 = Network.getInstance().create(ApiClient::class.java)
        apiClient3.getkidsandfamilyTv().enqueue(
            object : Callback<kidsandfamilyTv>{
                override fun onResponse(
                    call: Call<kidsandfamilyTv>,
                    response: Response<kidsandfamilyTv>,
                ) {
                    response.body()?.run {
                        dataX = data
                        setTVARecyler()
                    }
                }

                override fun onFailure(call: Call<kidsandfamilyTv>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

    private fun setTVARecyler() {

        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val dataX = kidsandfamilyTvAdaptor(dataX, this)
        rvkidsandfamilytv.adapter = dataX
        rvkidsandfamilytv.layoutManager = linearLayoutManager
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
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val kidsandfamilyAdaptor = kidsandfamilyAdaptor(listofkidsandfamily, this)
        rvkidsandfamily.adapter = kidsandfamilyAdaptor
        rvkidsandfamily.layoutManager = linearLayoutManager
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
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val kidsPickYouAdapter = KidsPickYouAdapter(listOfKidsPickYou)
        rvKidsPickYou.adapter = kidsPickYouAdapter
        rvKidsPickYou.layoutManager = linearLayoutManager
    }

    override fun onkidsTvclick(dataX: DataX, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.kidsFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", dataX.image)
        bundle.putString("movieName", dataX.movieName)
        bundle.putString("moviedescription",dataX.description)
        bundle.putString("movietime",
            dataX.timing + "    " + dataX.year)
        bundle.putString("movierating", dataX.rating)
        bundle.putString("DirectorImage", dataX.directorImage)
        bundle.putString("DirectorName", dataX.director)
        parentFragmentManager.setFragmentResult("Moviename", bundle)
    }

    override fun onInidanToonClick(indianToon: IndianToon, position: Int) {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.kidsFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", indianToon.image)
        bundle.putString("movieUrl",indianToon.movieTrailerLink)
        bundle.putString("movieName", indianToon.movieName)
        bundle.putString("moviedescription", indianToon.description)
        bundle.putString("movietime",
            indianToon.timing + "    " + indianToon.year)
        bundle.putString("movierating", indianToon.rating)
        bundle.putString("DirectorImage", indianToon.directorImage)
        bundle.putString("DirectorName", indianToon.director)
        parentFragmentManager.setFragmentResult("Moviename", bundle)
    }

    override fun onAmazonOriginal(amazonOriginalKid: AmazonOriginalKid, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.kidsFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", amazonOriginalKid.image)
        bundle.putString("movieName", amazonOriginalKid.movieName)
        bundle.putString("moviedescription", amazonOriginalKid.description)
        bundle.putString("movietime",
            amazonOriginalKid.timing + "    " + amazonOriginalKid.year)
        bundle.putString("movierating", amazonOriginalKid.rating)
        bundle.putString("DirectorImage", amazonOriginalKid.directorImage)
        bundle.putString("DirectorName", amazonOriginalKid.director)
        parentFragmentManager.setFragmentResult("Moviename", bundle)
    }

    override fun onitemclick(data: Data, position: Int) {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.kidsFragment, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("movieImage", listofkidsandfamily[position].image)
        bundle.putString("movieName", listofkidsandfamily[position].movieName)
        bundle.putString("moviedescription", listofkidsandfamily[position].description)
        bundle.putString("movietime",
            listofkidsandfamily[position].timing + "    " + listofkidsandfamily[position].year)
        bundle.putString("movierating", listofkidsandfamily[position].rating)
        bundle.putString("DirectorImage", listofkidsandfamily[position].directorImage)
        bundle.putString("DirectorName", listofkidsandfamily[position].director)
        parentFragmentManager.setFragmentResult("Moviename", bundle)

    }
}