package com.fxii.desafio3.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.bumptech.glide.Glide
import com.fxii.desafio3.R
import com.fxii.desafio3.databinding.ActivityCapaBinding
import com.fxii.desafio3.model.Image
import com.fxii.desafio3.model.Thumbnail

class CapaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCapaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCapaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // carrega imagem capa
        val imgCapa = intent.getParcelableExtra<Image>(DetalhesActivity.KEY_INTENT_CAPA)
        // Glide....
        imgCapa?.let {
            Glide.with(this)
                    //.load("${imgCapa.path}/portrait_incredible.${imgCapa.extension}")
                    .load(imgCapa.getFullPath(Image.PORTRAIT_INCREDIBLE))
                    .into(binding.ivCapaCapa)
        }

        binding.btnCapaVoltar.setOnClickListener {
            finish()
        }
    }
}