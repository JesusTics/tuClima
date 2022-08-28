package com.example.tuclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lat=intent.getStringExtra("lat")
        var long=intent.getStringExtra("long")
        Toast.makeText(this,lat+" "+long, Toast.LENGTH_LONG).show()

    }
}