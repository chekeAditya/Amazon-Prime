package com.example.primevideo.Fragments


import android.os.Bundle
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.primevideo.R

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_create_account.*


class CreateAccount : Fragment(R.layout.fragment_create_account) {
    private lateinit var navController: NavController
    private var mAuth = FirebaseAuth.getInstance()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnCOntinue.setOnClickListener {

            registerNewUser()
        }
        etCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            etCheckBox.transformationMethod = PasswordTransformationMethod.getInstance();

        }
        tvAlreadyAccount.setOnClickListener {
            navController.navigate(R.id.action_createAccount_to_signInFragment)
        }

    }

    private fun registerNewUser() {
     //   progressbar1.visibility = View.VISIBLE

        val email = etNumberOrEmail.text.toString()
        val password = etCreatePassword.text.toString()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(
                context,
                "Please enter email!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(
                context,
                "Please enter password!!",
                Toast.LENGTH_LONG
            )
                .show()
            return
        }
        mAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Registration successful!",
                        Toast.LENGTH_LONG
                    )
                        .show()
                   // progressbar1.visibility = View.GONE
                    navController.navigate(R.id.action_createAccount_to_mainActivity)

                } else {
                    Toast.makeText(
                        context,
                        "Registration failed!!"
                                + " Please try again later",
                        Toast.LENGTH_LONG
                    )
                        .show()

                  //  progressbar1.visibility = View.GONE
                }
            }
        val actionCodeSettings = actionCodeSettings {
            // URL you want to redirect back to. The domain (www.example.com) for this
            // URL must be whitelisted in the Firebase Console.
            url = "https://www.gmail.com/finishSignUp?cartId=1234"
            // This must be true
            handleCodeInApp = true
            setIOSBundleId("com.example.ios")
            setAndroidPackageName(
                "com.example.primevideo.Fragments",
                true, /* installIfNotAvailable */
                "12" /* minimumVersion */)
        }
        Firebase.auth.sendSignInLinkToEmail(email, actionCodeSettings)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Prachi", "Email sent.")
                }
            }
    }
}

