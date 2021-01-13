package com.fxii.desafio3.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fxii.desafio3.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
    }

    private fun setupObservables() {
        with(binding) {
            btnRegistrarVoltar.setOnClickListener{
                finish()
            }
        }
    }
}