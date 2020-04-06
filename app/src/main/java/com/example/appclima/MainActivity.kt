package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.w3c.dom.Text
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var tvCity : TextView? = null
    var tvGrd  : TextView? = null
    var tvEsta : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCity = findViewById(R.id.tvCiudad)
        tvGrd = findViewById(R.id.tvGrados)
        tvEsta = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.example.appclima.ciudades.CIUDAD")
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        if (Network.hayRed(this)){
            //ejecutar solicitud http
            //API 1ae0337496e9d486f0c99812fe01b854
            //CIUDAD DE GYE ID 3657509
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=1ae0337496e9d486f0c99812fe01b854&units=metric")
        }else{
            //mostrar mensaje de error
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }
    }

    //Metodo para Solicitud Volley
    private fun solicitudHTTPVolley(url : String){
        val queue = Volley.newRequestQueue(this )
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                Log.d("solicitudHTTPVolley", response)
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad :: class.java)
                tvCity?.text = ciudad.name
                tvGrd?.text = ciudad.main?.temp.toString()+"°"
                tvEsta?.text = ciudad.weather?.get(0)?.description
            }catch (e: IOException){
            }
        }, Response.ErrorListener{})
        queue.add(solicitud)
    }
}
