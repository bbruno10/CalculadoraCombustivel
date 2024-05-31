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
import com.example.calculadoracombustivel.databinding.ActivityConsumoBinding
import com.google.android.material.snackbar.Snackbar


class ConsumoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsumoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnVoltarFuel.setOnClickListener {
            val intent = Intent(this, CombustivelActivity::class.java)
            startActivity(intent)
        }

        binding.btnConsumo.setOnClickListener {
            if (binding.tieConsumo.text.toString() == ""){
                Snackbar.make(
                    binding.tieConsumo,
                    "Preencha a quilometragem ate o destino",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                val intent = Intent(this, DestinoActivity::class.java)
                startActivity(intent)

            }

            val consumo = binding.tieConsumo.text.toString()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("consumo", consumo)
            startActivity(intent)

        }
    }
}