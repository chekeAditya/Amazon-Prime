package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primevideo.Adapters.kidsandfamilytvexpansionAdaptor
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToon
import com.example.primevideo.Model.Kids.kidsandfamily.IndianToonsModel
import com.example.primevideo.Network.ApiClient
import com.example.primevideo.Network.Network
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_kidsandexpand.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class kidsandexpand : Fragment(R.layout.fragment_kidsandexpand) {

    private lateinit var indianToon: List<IndianToon>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(
            "kidsandfamilytv",
            this,
            FragmentResultListener() { s: String, bundle: Bundle ->
                kidsTv()

            })
    }

    private fun kidsTv() {
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

        val indianToon = kidsandfamilytvexpansionAdaptor(indianToon)
        rvkidsexpand.adapter = indianToon
        rvkidsexpand.layoutManager = GridLayoutManager(activity,2)
    }
}
