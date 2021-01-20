package com.fxii.desafio3.utils

import android.util.Log
import com.fxii.desafio3.services.ResponseMarvel
import retrofit2.Response

class ComicsResponseValidation {
    fun comicsDefaultResponseValidation(serviceResponse: Response<*>, error: String): ResponseMarvel {
        lateinit var response : Response<*>
        return try {
            response =  serviceResponse

            val isSuccessful = response.isSuccessful && response.body() != null

            if (isSuccessful) {
                ResponseMarvel.Success(response.body())
            } else {
                ResponseMarvel.Error("$error. Code: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("ERROR", "An error occurred trying to validate response from PeopleService. ${e.stackTrace}")
            ResponseMarvel.Error(error)
        }
    }
}