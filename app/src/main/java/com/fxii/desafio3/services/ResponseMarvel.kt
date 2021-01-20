package com.fxii.desafio3.services

sealed class ResponseMarvel {
    class Success(val data: Any?): ResponseMarvel()
    class Error(val message: String): ResponseMarvel()
}