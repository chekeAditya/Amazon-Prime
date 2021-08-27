package com.example.primevideo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.primevideo.Fragments.FindView.DramaGridLayout
import com.example.primevideo.R
import kotlinx.android.synthetic.main.fragment_find.*

class FragmentFind : Fragment(R.layout.fragment_find) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview(view)



    }

    private fun initview(view: View) {
        genresinit(view)
        Langinit(view)
        Mainbutton(view)
    }

    private fun Mainbutton(view: View) {
        MainMovie.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, MoviesFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        })
        MainTv.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, TvShowsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        })
        MainOriginal.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented fill amazon original fragment")
        })
        MainKids.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, KidsFragment())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
        })



    }

    private fun Langinit(view: View) {

        bEnglish.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bHindi.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bTelugu.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bTamil.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bKannada.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bMalayalam.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })



    }

    private fun genresinit(view: View) {
        bDrama.setOnClickListener(View.OnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, DramaGridLayout())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()
            val bundle = Bundle();
            bundle.putString("D","Drama")
            parentFragmentManager.setFragmentResult("Dramaname", bundle)

        })

        bAction.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container, DramaGridLayout())
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()

            val bundle = Bundle();
            bundle.putString("A","Action")
            parentFragmentManager.setFragmentResult("Actionname", bundle)

        })

        bRomance.setOnClickListener(View.OnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmenTransaction = fragmentManager.beginTransaction()
            fragmenTransaction.add(R.id.container,DramaGridLayout() )
            fragmenTransaction.addToBackStack(null)
            fragmenTransaction.commit()

            val bundle = Bundle();
            bundle.putString("R","Romance")
            parentFragmentManager.setFragmentResult("Romancename", bundle)

        })


        bComedy.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bThriller.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })

        bHorror.setOnClickListener(View.OnClickListener {
            TODO("Not yet implemented")
        })


    }



}


