package com.example.primevideo.Fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.primevideo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import kotlinx.android.synthetic.main.fragment_sign_in.*
import okhttp3.internal.userAgent

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private lateinit var navController: NavController
    private val mAuth = FirebaseAuth.getInstance()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnCreateAccount.setOnClickListener {
            navController.navigate(R.id.action_signInFragment_to_createAccount)
        }
        btnSignIn.setOnClickListener {

            loginUserAccount()

        }
    }

    private fun loginUserAccount() {
         progressbar.visibility = View.VISIBLE
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()



        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Login successful!!" + mAuth.currentUser!!.email, Toast.LENGTH_LONG).show()
                    progressbar.visibility = View.GONE
                    navController.navigate(R.id.action_signInFragment_to_mainActivity)
                } else {

                    Toast.makeText(context, "inValid Credentials ", Toast.LENGTH_LONG).show()
                    progressbar.visibility = View.GONE
                }
            }
    }
}





