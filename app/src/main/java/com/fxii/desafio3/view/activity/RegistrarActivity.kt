package com.fxii.desafio3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fxii.desafio3.R
import com.fxii.desafio3.databinding.ActivityRegistrarBinding
import com.fxii.desafio3.extensions.validateTextInputLayout

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

            btnRegistrarSalvar.setOnClickListener {
                val checkResult = tfRegistrarNome.validateTextInputLayout(R.string.nome)
                        .and(tfRegistrarEmail.validateTextInputLayout(R.string.emaill))
                        .and(tfRegistrarSenha.validateTextInputLayout(R.string.senha))

                if(checkResult) {
                    val intent = Intent(this@RegistrarActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}