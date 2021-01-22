package com.fxii.desafio3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.fxii.desafio3.R
import com.fxii.desafio3.databinding.ActivityDetalhesBinding
import com.fxii.desafio3.model.Comic
import com.fxii.desafio3.model.Image

class DetalhesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesBinding

    private var comic: Comic? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comic = intent.getParcelableExtra<Comic>(HomeActivity.KEY_INTENT_COMIC)

        setupComic()

        setupObservables()
    }

    private fun setupObservables() {
        with(binding) {
            btnDetalhesVoltar.setOnClickListener {
                finish()
            }

            flDetalhesCapa.setOnClickListener {
                val intent = Intent(this@DetalhesActivity, CapaActivity::class.java)
                intent.putExtra(DetalhesActivity.KEY_INTENT_CAPA, comic?.thumbnail)
                startActivity(intent)
            }
        }


    }

    private fun setupComic() {
        comic?.let { comic ->
            var desc = comic.description ?: comic.variantDescription

            if(desc.isNullOrBlank()) desc = "No description"

            val price = "$ %.2f".format(comic.prices[0].price)
            val date = comic.dates[0].getFormattedDate()
            val issue = comic.issueNumber.toString()
            val title = comic.title
            //val image = if(comic.images.count()>0) "${comic.images.last().path}/landscape_amazing.${comic.images.last().extension}" else null
            val image = if(comic.images.count()>0) comic.images.last().getFullPath(Image.LANDSCAPE_AMAZING) else null
            val thumbnail = comic.thumbnail.getFullPath(Image.PORTRAIT_MEDIUM) //"${comic.thumbnail.path}/portrait_medium.${comic.thumbnail.extension}"
            val pages = comic.pageCount.toString()

            with(binding) {
                Glide.with(this@DetalhesActivity)
                        .load(image)
                        .into(ivDetalhesPortrait)
                Glide.with(this@DetalhesActivity)
                        .load(thumbnail)
                        .into(ivDetalhesCapa)
                tvDetalhesTitulo.text = title
                tvDetalhesDescricao.text = desc
                tvDetalhesPublicacao.text = date
                tvDetalhesPreco.text = price
                tvDetalhesPaginas.text = pages
            }

        }
    }

    companion object {
        const val KEY_INTENT_CAPA = "capa"
    }
}