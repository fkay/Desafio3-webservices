package com.fxii.desafio3.model

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)