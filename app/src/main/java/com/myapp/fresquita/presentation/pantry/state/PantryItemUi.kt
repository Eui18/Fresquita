package com.myapp.fresquita.presentation.pantry.state

data class PantryItemUi(
    val id: String,
    val name: String,
    val quantity: String,
    val unit: String,
    val categoryText: Int,
    val statusText: Int?
)