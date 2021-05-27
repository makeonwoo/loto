package com.example.loto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber (): Int{
    return Random().nextInt(45)+1
}
fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    while(true){
        val number = getRandomLottoNumber()
        var flag_exist = 0
        if (lottoNumbers.contains(number)){
            flag_exist = 1
            continue
        }
        if(flag_exist==1)
            continue
        else{
            lottoNumbers.add(getRandomLottoNumber())
        }
        if(lottoNumbers.size>=6)
            break
    }
    return lottoNumbers
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Constellation = findViewById<CardView>(R.id.Consetllation)
        val name = findViewById<CardView>(R.id.Name)
        val random = findViewById<CardView>(R.id.random)
        random.setOnClickListener {
            val intent = Intent(this@MainActivity,ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }
        Constellation.setOnClickListener {
            startActivity(Intent(this@MainActivity,ConstellationActivity::class.java))
        }
        name.setOnClickListener {
            startActivity(Intent(this@MainActivity,NameActivity::class.java))
        }
    }
}