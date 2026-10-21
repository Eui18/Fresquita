package com.myapp.fresquita.presentation.pantry.state

import com.myapp.fresquita.data.model.FoodCategory

data class PantryUiState(
    val items: List<PantryItemUi> = emptyList(),
    val selectedCategory: FoodCategory? = null,
    val foodToDeleteId: String? = null
)