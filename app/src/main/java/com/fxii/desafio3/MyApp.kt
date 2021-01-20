package com.fxii.desafio3

import android.app.Application

class MyApp: Application() {
    companion object {
        lateinit var instance: MyApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}