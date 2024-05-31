package com.example.calculadoracombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracombustivel.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val preco = intent.getStringExtra("preco")
        binding.tvInfoPreco.text = preco.toString()

        val edtConsumo = intent.getStringExtra("consumo")
        binding.tvInfoConsumo.text = edtConsumo.toString()

        val distancia = intent.getStringExtra("distancia")
        binding.tvInfoKm.text = distancia.toString()

        val Mvalor = preco.toString().toFloat()
        val Mkm = distancia.toString().toFloat()
        val Mconsumo = edtConsumo.toString().toFloat()

        val valor = Mvalor / Mkm
        val result = valor * Mconsumo

        binding.tvResultado.text = result.toString()

        binding.btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, CombustivelActivity::class.java)
            startActivity(intent)
        }
    }
}