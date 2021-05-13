package com.example.loto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Constellation = findViewById<CardView>(R.id.Consetllation)

        Constellation.setOnClickListener {
            startActivity(Intent(this@MainActivity,ConstellationActivity::class.java));
        }
    }
}