package com.fxii.desafio3.repository

import com.fxii.desafio3.services.ComicsServiceClient
import com.fxii.desafio3.services.ResponseMarvel
import com.fxii.desafio3.utils.ComicsResponseValidation

class ComicsRepository {
    val comicsService = ComicsServiceClient.comicsServiceAPI

    val comicsResponseValidation = ComicsResponseValidation()

    suspend fun getComics():ResponseMarvel {
        return comicsResponseValidation.comicsDefaultResponseValidation(
            comicsService.getComics(), "Falha ao ler revistas"
        )
    }
}