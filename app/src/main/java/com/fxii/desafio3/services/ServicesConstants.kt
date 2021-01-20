package com.fxii.desafio3.services

import android.content.Context
import com.fxii.desafio3.MyApp
import com.fxii.desafio3.R
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

object ServicesConstants {
    val MARVEL_PUBLIC_KEY = getMarvelPublicKey()
    val MARVEL_PRIVATE_KEY = getMarvelPrivateKey()

    val MARVEL_BASE_URL = "https://gateway.marvel.com:443/v1/public/"

    fun getMarvelPublicKey(): String {
        return MyApp.instance.getString(R.string.marvel_public)
    }

    fun getMarvelPrivateKey(): String {
        return MyApp.instance.getString(R.string.marvel_private)
    }

    fun getMarvelHash(ts: String): String {
        var str = ts + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY
        val hash = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
        return hash.joinToString ("") { "%02x".format(it) }
    }

}