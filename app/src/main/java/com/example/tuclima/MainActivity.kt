package com.example.tuclima

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    //Duracion de la SplashScreen
    val DURACION: Long = 3000;



    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Poner full la pantalla
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Insertar imagen en el ImageView que se creo
        val logo = findViewById<ImageView>(R.id.gifLogo)
        Glide.with(this).load(R.drawable.ic_launcher_background)
        cambiarActividad()
    }

    //Actividad para cambiar de pantalla a la segunda actividad
    private fun cambiarActividad(){
        Handler().postDelayed(Runnable {
            val intent = Intent(this, clima::class.java)
            startActivity(intent)
        }, DURACION)
    }

}