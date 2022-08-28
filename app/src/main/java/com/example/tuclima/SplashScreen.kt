package com.example.tuclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.delay

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Handler para el SplashScreen y poder hacer el cambio a la MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
                var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3500)

    }
}