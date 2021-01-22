package com.fxii.desafio3.model

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class Date(
    val date: String,
    val type: String
) : Parcelable {
    fun getFormattedDate(): String {
        try {
            var dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            val dateTs = dateFormat.parse(date)
            dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.US)
            return dateFormat.format(dateTs)
        } catch (e: Exception) {
            Log.e("Erro", "Erro ao transformar a data")
            return ""
        }
    }
}