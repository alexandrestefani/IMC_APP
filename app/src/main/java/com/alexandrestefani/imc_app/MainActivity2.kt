package com.alexandrestefani.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity2 : AppCompatActivity() {
    var pesoInt = 0
    var altD =0.0
    var imc = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val dados = intent.extras
        var peso = dados?.getString("peso")
        var altura = dados?.getString("alt")

        pesoInt = peso?.toInt()!!
        altD = altura?.toDouble()!!

        imc = pesoInt /(altD*altD)
        var show_imc = findViewById<TextView>(R.id.textotela2)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundoff = df.format(imc)
        show_imc.text = roundoff.toString()

        val button = findViewById<ImageButton>(R.id.imageButtontela2)
        button.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val imagem = findViewById<ImageView>(R.id.imagemtela2)
        val classif = findViewById<TextView>(R.id.classific)

        when{
            imc < 18.5 ->{
                imagem.setImageResource(R.drawable.magreza)
                classif.text = "Magreza"
            }
            imc < 24.9 -> {
                imagem.setImageResource(R.drawable.normal)
                classif.text = "Magreza"
            }
            imc < 30 -> {
                imagem.setImageResource(R.drawable.sobrepeso)
                classif.text = "Sobrepeso"
            }
            else -> {
                imagem.setImageResource(R.drawable.obesidade)
                classif.text = "Obesidade"
            }
        }
    }
}