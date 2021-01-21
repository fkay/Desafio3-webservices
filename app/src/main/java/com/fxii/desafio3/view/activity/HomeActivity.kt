package com.fxii.desafio3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.fxii.desafio3.R
import com.fxii.desafio3.databinding.ActivityHomeBinding
import com.fxii.desafio3.view.adapter.CapaAdapter
import com.fxii.desafio3.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListaRevistasCapas.adapter = null

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.getComics()

        setupObservables()
    }

    private fun setupObservables() {
        homeViewModel.comicsLiveData.observe(this) {
            it?.let { comics ->
                binding.rvListaRevistasCapas.apply {
                    adapter = CapaAdapter(comics) { position ->
                        Log.i("Teste", "cliquei na capa ${position}")
                        val intent = Intent(this@HomeActivity, DetalhesActivity::class.java)
                        intent.putExtra(KEY_INTENT_COMIC, comics[position])
                        startActivity(intent)
                    }
                }
            }
        }
    }

    companion object {
        const val KEY_INTENT_COMIC = "COMIC"
    }
}