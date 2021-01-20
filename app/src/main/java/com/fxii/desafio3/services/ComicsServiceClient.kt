package com.fxii.desafio3.services

import com.fxii.desafio3.interceptor.DefaultMarvelInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ComicsServiceClient {
    val comicsServiceAPI = getComicsClient().create(ComicsService::class.java)

    private fun getComicsClient(): Retrofit {
        val interceptor = DefaultMarvelInterceptor.defaultInterceptor

        return Retrofit.Builder()
                .baseUrl(ServicesConstants.MARVEL_BASE_URL)
                .client(interceptor)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}