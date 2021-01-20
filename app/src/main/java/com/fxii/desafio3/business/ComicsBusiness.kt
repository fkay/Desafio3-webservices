package com.fxii.desafio3.business

import com.fxii.desafio3.repository.ComicsRepository
import com.fxii.desafio3.services.ResponseMarvel

class ComicsBusiness() {
    private val comicsRepository: ComicsRepository by lazy {
        ComicsRepository()
    }

    suspend fun getComics():ResponseMarvel {
        return comicsRepository.getComics()
    }

}