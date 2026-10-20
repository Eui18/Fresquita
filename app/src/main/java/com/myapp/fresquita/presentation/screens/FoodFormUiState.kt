package com.myapp.fresquita.presentation.screens

import com.myapp.fresquita.data.model.FoodCategory

data class FoodFormUiState(
    val name: String = "",
    val category: FoodCategory = FoodCategory.FRUITS,
    val quantity: String = "",
    val unit: String = "",
    val expirationDate: String = "",
    val nameError: Boolean = false,
    val quantityError: Boolean = false,
    val unitError: Boolean = false,
    val dateError: Boolean = false,
    val isSaved: Boolean = false
)