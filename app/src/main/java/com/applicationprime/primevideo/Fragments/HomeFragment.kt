package com.applicationprime.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationprime.primevideo.Adapters.*
import com.applicationprime.primevideo.Model.*
import com.applicationprime.primevideo.Model.Perfect.PerfectResponseModel
import com.applicationprime.primevideo.Model.Perfect.PerfectResult
import com.applicationprime.primevideo.Model.Shows.ShowsItem
import com.applicationprime.primevideo.Network.ApiClient
import com.applicationprime.primevideo.Network.Network
import com.applicationprime.primevideo.Network.OnHomeListener
import com.applicationprime.primevideo.Network.OnItemMovieClick
import com.applicationprime.primevideo.R
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.imageSlider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home),OnHomeListener,OnItemMovieClick {

    private lateinit var listOfPopularMovies: List<ResultModel>
    private lateinit var listOfPopularShows: List<ShowsItem>
    private lateinit var listOfPerfectItem: List<PerfectResult>
    private lateinit var listOfLatestMovie: List<MovieApiList>
    private lateinit var listOfactionmovie: List<ActionMovieListResponse>
    private lateinit var listOfLatestComedyMovie: List<ResponseComedyList>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSliderView()
        PopularMovieApiCall()
        PopularShowApiCall()
        LatestActionMovie()
        LatestComedyMovie()
        NewMovie()
        imageSlider.setOnClickListener{
            Toast.makeText(context,"AvailableSoon",Toast.LENGTH_SHORT).show()
        }
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
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularMoviesAdapter = PopularMoviesAdapter(listOfPopularMovies)
        rvPopularMovies.adapter = popularMoviesAdapter
        rvPopularMovies.layoutManager = linearLayoutManager
    }

    private fun PopularShowApiCall() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getPerfectShow().enqueue(object : Callback<PerfectResponseModel> {
            override fun onResponse(call: Call<PerfectResponseModel>, response: Response<PerfectResponseModel>) {
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
        var linearLayoutManager1 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularSeasonAdapter = PopularSeasonAdapter(listOfPerfectItem)
        rvPopularSeason.adapter = popularSeasonAdapter
        rvPopularSeason.layoutManager = linearLayoutManager1
    }

    override fun onPopular(popularMovie: ResultModel, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fragHome, MoviesFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()


        val bundle = Bundle();
        bundle.putString("PopularImage", popularMovie.posterPath)
        bundle.putString("PopularName", popularMovie.title)
        bundle.putString("Populardescription", popularMovie.overview)
        Toast.makeText(context,"clickable",Toast.LENGTH_LONG).show()
        parentFragmentManager.setFragmentResult("Popularname", bundle)
    }

    override fun onPerfect(perfectMovie: PerfectResult, position: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmenTransaction = fragmentManager.beginTransaction()
        fragmenTransaction.add(R.id.fragHome, MoviePreviewFragment())
        fragmenTransaction.addToBackStack(null)
        fragmenTransaction.commit()

        val bundle = Bundle();
        bundle.putString("PerfectImage", perfectMovie.posterPath)
        bundle.putString("PerfectName", perfectMovie.title)
        bundle.putString("Perfectdescription", perfectMovie.overview)
        parentFragmentManager.setFragmentResult("Perfectname", bundle)
    }






    private fun LatestActionMovie() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.LatestActionMovie().enqueue(object : Callback<MovieApi> {
            override fun onResponse(call: Call<MovieApi>, response: Response<MovieApi>) {
                response.body()?.run {
                    listOfLatestMovie = data
                    LatestactionRecycler()
                }
            }

            override fun onFailure(call: Call<MovieApi>, t: Throwable) {
                Toast.makeText(
                    context,
                    "Failure in popular show api call" + t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun LatestactionRecycler() {
        var linearLayoutManager1 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val latestMovieAdapter = LatestMovieAdapter(listOfLatestMovie)
        Latestrecycler.adapter = latestMovieAdapter
        Latestrecycler.layoutManager = linearLayoutManager1
    }







    private fun LatestComedyMovie() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.LatestComedyMovie().enqueue(object : Callback<ResponseComedy> {
            override fun onResponse(call: Call<ResponseComedy>, response: Response<ResponseComedy>) {
                response.body()?.run {
                    listOfLatestComedyMovie = data
                    LatestComedyRecycler()
                }
            }

            override fun onFailure(call: Call<ResponseComedy>, t: Throwable) {
                Toast.makeText(
                    context,
                    "Failure in popular show api call" + t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun LatestComedyRecycler() {
        var linearLayoutManager1 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val latestMovieAdapter = LatestComedyAdapter(listOfLatestComedyMovie)
        Comedyrecycler.adapter = latestMovieAdapter
        Comedyrecycler.layoutManager = linearLayoutManager1
    }






    private fun NewMovie() {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getLatestMovies().enqueue(object : Callback<List<ActionMovieListResponse>> {
            override fun onResponse(call: Call<List<ActionMovieListResponse>>, response: Response<List<ActionMovieListResponse>>) {

                    listOfactionmovie = response.body()!!
                    NewRecycler()

            }

            override fun onFailure(call: Call<List<ActionMovieListResponse>>, t: Throwable) {
                Toast.makeText(
                    context,
                    "Failure in popular show api call" + t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun NewRecycler() {
        var linearLayoutManager1 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val latestMovieAdapter = ActionMovieAdapter(listOfactionmovie,this)
        Mystryrecycler.adapter = latestMovieAdapter
        Mystryrecycler.layoutManager = linearLayoutManager1
    }

    override fun onDramaClick(drama: DramaDataList, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onActionClick(action: ActionMovieListResponse, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onRomanceClick(romance: RomanceData, position: Int) {
        TODO("Not yet implemented")
    }


}