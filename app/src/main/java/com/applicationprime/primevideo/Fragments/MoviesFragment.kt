package com.applicationprime.primevideo.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationprime.primevideo.Adapters.ActionMovieAdapter
import com.applicationprime.primevideo.Adapters.MySliderImageAdapter
import com.applicationprime.primevideo.Adapters.DramaMovieAdapter
import com.applicationprime.primevideo.Adapters.RomanceMovieAdapter
import com.applicationprime.primevideo.Model.*
import com.applicationprime.primevideo.Network.ApiClient
import com.applicationprime.primevideo.Network.Network
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import kotlinx.android.synthetic.main.fragment_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment(R.layout.fragment_movies),OnItemMovieClick {

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
        imageList.add("https://image.tmdb.org/t/p/w500/2RG1H4Blcv6pdufs3YxFg6vZMVd.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/kXaSLb7reKixWqujYqV8R4XybGo.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/yB0qFvou5I8dJrsg3vVtKmkRjVG.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/FWJbhAPdwiwKhUaAyz841jpYa1.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/irVU3PHIdg36Rh8tSKnKCdmHLEO.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/1k6iwC4KaPvTBt1JuaqXy3noZRY.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/qoPBiN6PBs2NsP7BNOJGCnmwruG.jpg")
        imageList.add("https://image.tmdb.org/t/p/w500/wt5p1WkBu7Ma3Jfyb6rGLs9ouvj.jpg")
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
        var topMovieAdapter = DramaMovieAdapter(listofData,this)
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
        var latestMovieAdapter = ActionMovieAdapter(listofActionMovieListResponse,this)
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
        var romanceMovieAdapter = RomanceMovieAdapter(listofRomanceData1,this)
        ivRomanticMovierecycler.adapter = romanceMovieAdapter
        ivRomanticMovierecycler.layoutManager = linearLayoutManager
    }

    override fun onDramaClick(drama: DramaDataList, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fragmentMovies, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("DramaImage", drama.image)
        bundle.putString("movieUrl",drama.movieTrailerLink)
        bundle.putString("DramaName", drama.movieName)
        bundle.putString("Dramadescription", drama.description)
        bundle.putString("Dramatime",
            drama.timing + "    " + drama.year)
        bundle.putString("Dramarating", drama.rating)
        bundle.putString("DramaDirectorImage", drama.directorImage)
        bundle.putString("DramaDirectorName", drama.director)
        parentFragmentManager.setFragmentResult("Dramaname", bundle)
    }

    override fun onActionClick(action: ActionMovieListResponse, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fragmentMovies, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("ActionImage", action.image)
        bundle.putString("movieUrl",action.movieTrailerLink)
        bundle.putString("ActionName", action.movieName)
        bundle.putString("Actiondescription", action.description)
        bundle.putString("ActionDirectorName", action.director)
        parentFragmentManager.setFragmentResult("Actionname", bundle)
    }

    override fun onRomanceClick(romance: RomanceData, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fragmentMovies, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("romanceImage", romance.image)
        bundle.putString("movieUrl",romance.movieTrailerLink)
        bundle.putString("romanceName", romance.movieName)
        bundle.putString("romancedescription", romance.description)
        bundle.putString("romancetime",
            romance.timing + "    " + romance.year)
        bundle.putString("romancerating", romance.rating)
        bundle.putString("romanceDirectorImage", romance.directorImage)
        bundle.putString("romanceDirectorName", romance.director)
        parentFragmentManager.setFragmentResult("romancename", bundle)
    }


}