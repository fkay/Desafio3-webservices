package com.fxii.desafio3.services

import com.fxii.desafio3.model.Comics
import retrofit2.Response
import retrofit2.http.GET

interface ComicsService {
    @GET("characters/1009610/comics")
    suspend fun getComics(): Response<Comics>
}