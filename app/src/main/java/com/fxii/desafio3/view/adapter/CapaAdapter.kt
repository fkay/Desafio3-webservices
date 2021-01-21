package com.fxii.desafio3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fxii.desafio3.R
import com.fxii.desafio3.model.Comic

class CapaAdapter(
        private val comics: List<Comic>,
        private val onItemCliked: (Int) -> Unit
): RecyclerView.Adapter<CapaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lista_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comics[position], onItemCliked)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comic: Comic, onItemCliked: (Int) -> Unit): Unit= with(itemView) {
            // carrega imagem capa
            val ivCapaItemHome = findViewById<AppCompatImageView>(R.id.ivItemHomeCapa)
            Glide.with(itemView.context)
                    .load("${comic.thumbnail.path}/portrait_medium.${comic.thumbnail.extension}")
                    .into(ivCapaItemHome)

            findViewById<TextView>(R.id.tvItemHomeNumeroEdicao).text = "#${comic.issueNumber.toString()}"

            findViewById<FrameLayout>(R.id.llItemHomeContainer).setOnClickListener {
                onItemCliked(adapterPosition)
            }
        }
    }

}