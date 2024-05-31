package com.example.calculadoracombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracombustivel.databinding.ActivityCombustivelBinding
import com.google.android.material.snackbar.Snackbar

class CombustivelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCombustivelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCombustivelBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnPreco.setOnClickListener {

            if (binding.tiePreco.text.toString() == "") {
                Snackbar.make(
                    binding.tiePreco,
                    "Preencha a quilometragem ate o destino",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                val intent = Intent(this, ConsumoActivity::class.java)
                startActivity(intent)
            }

            val preco = binding.tiePreco.text.toString()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("preco", preco)
            startActivity(intent)
        }
    }
}

