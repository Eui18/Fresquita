package com.myapp.fresquita.presentation.common

fun formatQuantity(quantity: Double): String {
    return if (quantity % 1.0 == 0.0) quantity.toLong().toString() else quantity.toString()
}