package com.fxii.desafio3.services

import retrofit2.Retrofit

object ComicsServiceClient {
    val comicsServiceAPI = getComicsClient().create(ComicsService::class.java)

    private fun getComicsClient(): Retrofit {


    }
}