package com.alexandrestefani.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.alexandrestefani.imc_app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var peso: EditText? = null
    var altura: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peso = findViewById<EditText>(R.id.peso)
        altura  = findViewById<EditText>(R.id.altura)


       val activity1to2Intent = Intent(this, MainActivity2::class.java)

        binding.buttontela1.setOnClickListener{
            // metodo para enviar dados do EditText para a outra tela,, deve ser enviado o conteúdo da apenas.
            activity1to2Intent.putExtra("peso",peso?.text.toString().orEmpty())
            activity1to2Intent.putExtra("alt",altura?.text.toString().orEmpty())
            startActivity(activity1to2Intent)
        }
    }
}
private fun Intent.putExtra(s: String, peso: EditText?) {

}
