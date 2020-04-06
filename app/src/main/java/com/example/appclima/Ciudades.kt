package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    val TAG  = "com.example.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        val btnGye = findViewById<Button>(R.id.btGye)
        val btnEst = findViewById<Button>(R.id.btEst)

        btnGye.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Guayaquil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3657509")
            startActivity(intent)
        })
        btnEst.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Estambul", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "745044")
            startActivity(intent)
        })
    }
}
