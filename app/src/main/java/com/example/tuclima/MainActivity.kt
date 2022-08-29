package com.example.tuclima

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    //Boton para buscar
    var btn1: Button?= null

    //CardView para los paises mas populares
    var btn_usa: CardView?=null
    var btn_mex: CardView?=null
    var btn_fra: CardView?=null
    var btn_ing: CardView?=null
    var btn_esp: CardView?=null
    var btn_jap: CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val lat=intent.getStringExtra("lat")
        var long=intent.getStringExtra("long")
        var flag1="New York"


        window.statusBarColor= Color.parseColor("#42B839")
        getJsonData()

        //Boton para buscar
        btn1=findViewById(R.id.btn_buscar)
        //Funcion del boton
        btn1!!.setOnClickListener{
            getJsonData()
        }

        //Botones para los paises populares
        btn_usa=findViewById(R.id.usa)
        btn_esp=findViewById(R.id.esp)
        btn_fra=findViewById(R.id.fra)
        btn_jap=findViewById(R.id.jap)
        btn_mex=findViewById(R.id.mex)
        btn_ing=findViewById(R.id.ing)
        //Funcion de los botones

        btn_usa!!.setOnClickListener{
            txt_ciudad.setText("New York")
            getJsonData()
        }
        btn_esp!!.setOnClickListener{
            txt_ciudad.setText("Barcelona")
            getJsonData()
        }
        btn_fra!!.setOnClickListener{
            txt_ciudad.setText("Paris")
            getJsonData()
        }
        btn_jap!!.setOnClickListener{
            txt_ciudad.setText("Tokio")
            getJsonData()
        }
        btn_mex!!.setOnClickListener{
            txt_ciudad.setText("Mexicali")
            getJsonData()
        }
        btn_ing!!.setOnClickListener{
            txt_ciudad.setText("Londres")
            getJsonData()
        }
    }
    private fun getJsonData()
    {
        val API_KEY="25555992fe70125719c4f526b4729330"
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.openweathermap.org/data/2.5/forecast?q=${txt_ciudad.text}&zip=${txt_cp.text}&appid=${API_KEY}"
        val jsonRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
              setValues(response)
            },
            Response.ErrorListener { Toast.makeText(this,"ERROR",Toast.LENGTH_LONG).show() })

        queue.add(jsonRequest)

    }
    private fun setValues(response:JSONObject){
        inf_ciudad.text=response.getJSONObject("city").getString("name")
        var temperatura=response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp")
        //Operacion para convertir los grados
        temperatura=((((temperatura).toFloat()-273.15)).toInt()).toString()
        inf_temperatura.text=temperatura + "°C"
        //Temperatura maxima
        var tempMax = response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp_max")
        tempMax=((((tempMax).toFloat()-273.15)).toInt()).toString()
        inf_temp_max.text=tempMax + "°C"
        //Temperatura Minima
        var tempMin = response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("temp_min")
        tempMin=((((tempMin).toFloat()-273.15)).toInt()).toString()
        inf_temp_min.text=tempMin + "°C"
        //Presion
        inf_presion.text=response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("pressure") +" hPa"
        //Humedad
        inf_humedad.text=response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("humidity") + "%"
        //Sensacion termica
        var sensacion = response.getJSONArray("list").getJSONObject(0).getJSONObject("main").getString("feels_like")
        sensacion=((((sensacion).toFloat()-273.15)).toInt()).toString()
        inf_sens_term.text=sensacion + "°C"
    }

}