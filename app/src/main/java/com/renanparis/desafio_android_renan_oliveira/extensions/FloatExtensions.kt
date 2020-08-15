package com.renanparis.desafio_android_renan_oliveira.extensions

import java.text.NumberFormat
import java.util.*

fun Float.formatCurrency() : String {

    return NumberFormat.getCurrencyInstance(
        Locale("en", "US")).format(this)
}