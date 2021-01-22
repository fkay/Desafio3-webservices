package com.fxii.desafio3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fxii.desafio3.R
import com.fxii.desafio3.databinding.ActivityLoginBinding
import com.fxii.desafio3.extensions.validateTextInputLayout
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
    }

    private fun setupObservables() {
        with(binding) {
            btnLoginRegistrar.setOnClickListener{
                val intent = Intent(this@LoginActivity, RegistrarActivity::class.java)
                startActivity(intent)
            }

            btnLoginLogin.setOnClickListener {
                val checkResult = tfLoginEmail.validateTextInputLayout(R.string.emaill)
                        .and(tfLoginSenha.validateTextInputLayout(R.string.senha))

                if(checkResult) {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}