package com.fxii.desafio3.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.fxii.desafio3.R

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        // carrega imagem capa
        // Glide....

        findViewById<AppCompatImageButton>(R.id.btnCapaVoltar).setOnClickListener {
            finish()
        }
    }
}