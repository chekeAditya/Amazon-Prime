package com.applicationprime.primevideo.Fragments


import android.os.Bundle
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.applicationprime.primevideo.R
import com.google.firebase.auth.FirebaseAuth
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
        progressbar1.visibility = View.VISIBLE

        val name = etName.text.toString()
        val email = etNumberOrEmail.text.toString()
        val password = etCreatePassword.text.toString()

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Please enter Name!!", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mAuth.currentUser?.sendEmailVerification()?.addOnCompleteListener {
                        if (it.isSuccessful)
                            if (mAuth.currentUser!!.isEmailVerified) {
                                Toast.makeText(
                                    context,
                                    "Registration successful!" + mAuth.currentUser!!.displayName , Toast.LENGTH_LONG
                                ).show()
                                navController.navigate(R.id.action_createAccount_to_mainActivity)
                            }

                    }
                    progressbar1.visibility = View.GONE
                } else {
                    Toast.makeText(
                        context,
                        "Registration failed!!" + "inValid Credentials",
                        Toast.LENGTH_LONG
                    ).show()

                    progressbar1.visibility = View.GONE
                }
            }

    }
}

