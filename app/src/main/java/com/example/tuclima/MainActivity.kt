package com.example.tuclima

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lat=intent.getStringExtra("lat")
        var long=intent.getStringExtra("long")


        window.statusBarColor= Color.parseColor("#42B839")
        getJsonData()

    }
    private fun getJsonData()
    {
        val API_KEY="25555992fe70125719c4f526b4729330"
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.openweathermap.org/data/2.5/forecast?q=${txt_ciudad.text}&appid=${API_KEY}"
        val jsonRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
              setValues(response)
            },
            Response.ErrorListener { Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show() })

        queue.add(jsonRequest)

    }
    private fun setValues(response:JSONObject){
        coordenadas.text=response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp")
        //coordenadas.text=response.getJSONObject("city").getString("id")


    }

}