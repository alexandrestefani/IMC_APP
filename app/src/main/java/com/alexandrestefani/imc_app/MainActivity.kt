package com.alexandrestefani.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.alexandrestefani.imc_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var peso: EditText? = null
    var altura: EditText? = null
    var cont =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peso = findViewById<EditText>(R.id.peso)
        altura  = findViewById<EditText>(R.id.altura)

        val buttonfechar = findViewById<ImageButton>(R.id.imagebuttonfechar)
        buttonfechar.setOnClickListener{
            finishAffinity()
        }

        val button = findViewById<ImageButton>(R.id.imagembutton01)
        button.setOnClickListener {
            cont= this.cont+1
            when(cont){


                1 ->{
                    val secondfragment = MuitomagroFragment.newInstance("alexandre","stefani")
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragmentContainerView3,secondfragment)
                    fragmentTransaction.commit()
                }

                2 -> {
                    val thirdfragment = NormalFragment.newInstance("alexandre","stefani")
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragmentContainerView3,thirdfragment)
                    fragmentTransaction.commit()
                }
                3 -> {
                    val fourthfragment = SobrepesoFragment.newInstance("alexandre","stefani")
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragmentContainerView3,fourthfragment)
                    fragmentTransaction.commit()
                }
                4 -> {
                    val fivethfragment = ObesidadeFragment.newInstance("alexandre", "stefani")
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragmentContainerView3, fivethfragment)
                    fragmentTransaction.commit()
                }
                5 -> {
                    cont = cont - 5
                    val firstfragment = FragmentoMain.newInstance("alexandre","stefani")
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragmentContainerView3,firstfragment)
                    fragmentTransaction.commit()

                }



            }

        }
        //Criação de framento por código, importante no conteiner não conter "nome"
        val firstfragment = FragmentoMain.newInstance("alexandre","stefani")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerView3,firstfragment)
        fragmentTransaction.commit()

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
