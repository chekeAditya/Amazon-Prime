package com.example.primevideo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_create_account.*

class CreateAccount : Fragment(R.layout.fragment_create_account) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnCOntinue.setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_createAccount)
        }
    }
}