package com.fxii.desafio3.extensions

import com.fxii.desafio3.R
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validateTextInputLayout(field: Int) : Boolean {
    val value = this.editText?.text.toString()
    if(value.isBlank()) {
        this.error = this.context.getString(R.string.campo_obrigatorio,
                this.context.getString(field))
        return false
    }
    this.isErrorEnabled = false
    return true
}