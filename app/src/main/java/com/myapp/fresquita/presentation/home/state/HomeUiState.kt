package com.myapp.fresquita.presentation.home.state

import com.myapp.fresquita.presentation.common.FoodItemUi

data class HomeUiState(
    val availableCount: Int = 0,
    val expiringSoonCount: Int = 0,
    val expiringItems: List<FoodItemUi> = emptyList()
)