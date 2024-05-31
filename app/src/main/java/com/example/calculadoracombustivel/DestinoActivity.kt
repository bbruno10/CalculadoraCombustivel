package com.example.calculadoracombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracombustivel.databinding.ActivityDestinoBinding
import com.google.android.material.snackbar.Snackbar


class DestinoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDestinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityDestinoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnBackDestino.setOnClickListener {
            val intent = Intent(this, ConsumoActivity::class.java)
            startActivity(intent)
        }

        binding.btnDistancia.setOnClickListener {

            if (binding.tieDestino.text.toString() == "") {
                Snackbar.make(
                    binding.tieDestino,
                    "Preencha a quilometragem ate o destino",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                val intent = Intent(this, ResultadoActivity::class.java)
                startActivity(intent)
            }

            val distancia = binding.tieDestino.text.toString()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("distancia", distancia)
            startActivity(intent)
        }
    }
}