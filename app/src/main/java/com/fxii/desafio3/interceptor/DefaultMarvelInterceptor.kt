package com.fxii.desafio3.interceptor

import android.content.Context
import com.fxii.desafio3.R
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object DefaultMarvelInterceptor(context: Context) {
    val defaultInterceptor = getMarvelInterceptorClient()

    private fun getMarvelInterceptorClient(): OkHttpClient {
        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val ts = System.currentTimeMillis()
                var url = chain.request().url()
                url = url.newBuilder()
                    .addQueryParameter("ts", ts.toString())
                    .addQueryParameter("apikey", context.getString(R.string.MARVEL_PUBLIC_KEY))
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