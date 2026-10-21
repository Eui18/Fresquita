package com.myapp.fresquita.presentation.pantry.state

import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.presentation.common.ExpirationStatus

data class PantryItem(
    val food: Food,
    val status: ExpirationStatus
)

data class PantryUiState(
    val items: List<PantryItem> = emptyList()
)