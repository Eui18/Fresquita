package com.myapp.fresquita.presentation.screens

import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.presentation.util.ExpirationStatus

data class PantryItem(
    val food: Food,
    val status: ExpirationStatus
)

data class PantryUiState(
    val items: List<PantryItem> = emptyList()
)