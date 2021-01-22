package com.fxii.desafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val extension: String,
    val path: String
) : Parcelable {
        fun getFullPath(size: Int) : String {
            return when(size) {
                LANDSCAPE_AMAZING -> "${path}/landscape_amazing.${extension}"
                PORTRAIT_MEDIUM -> "${path}/portrait_medium.${extension}"
                PORTRAIT_INCREDIBLE -> "${path}/portrait_incredible.${extension}"
                else -> ""
            }
        }

        companion object {
        const val LANDSCAPE_AMAZING = 0
        const val PORTRAIT_MEDIUM = 1
        const val PORTRAIT_INCREDIBLE = 2
        }
}