package com.myapp.fresquita.presentation.pantry.state

import com.myapp.fresquita.presentation.common.FoodItemUi

data class PantryUiState(
    val items: List<FoodItemUi> = emptyList(),
    val foodToDeleteId: String? = null
)