package com.myapp.fresquita.data.model

data class Food(
    val id: String,
    val name: String,
    val category: FoodCategory,
    val quantity: Double,
    val unit: String,
    val expirationDate: String?,
    val isConsumed: Boolean,
    val illustrationKey: String
)