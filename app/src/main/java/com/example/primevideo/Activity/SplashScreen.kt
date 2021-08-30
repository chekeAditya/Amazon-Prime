package com.example.primevideo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.primevideo.R

import android.content.Intent


class SplashScreen : AppCompatActivity() {
    var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        handler = Handler()
        handler!!.postDelayed({
            val intent = Intent(this@SplashScreen, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}