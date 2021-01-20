package com.fxii.desafio3.interceptor

import android.content.Context
import com.fxii.desafio3.R
import com.fxii.desafio3.services.ServicesConstants
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object DefaultMarvelInterceptor {
    val defaultInterceptor = getMarvelInterceptorClient()

    private fun getMarvelInterceptorClient(): OkHttpClient {
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val ts = System.currentTimeMillis().toString()
                var url = chain.request().url()
                url = url.newBuilder()
                    .addQueryParameter("ts", ts)
                    .addQueryParameter("apikey", ServicesConstants.MARVEL_PUBLIC_KEY)
                    .addQueryParameter("hash", ServicesConstants.getMarvelHash(ts))
                    .build()
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                )
            }

        return interceptor.build()
    }


}