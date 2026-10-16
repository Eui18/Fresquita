package com.myapp.fresquita.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class HomeViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadSummary()
    }

    private fun loadSummary() {
        val availableFoods = repository.getFoods().filter { !it.isConsumed }
        val today = LocalDate.now()
        val expiringSoon = availableFoods.count { isExpiringSoon(it, today) }

        _uiState.update {
            it.copy(
                availableCount = availableFoods.size,
                expiringSoonCount = expiringSoon
            )
        }
    }

    private fun isExpiringSoon(food: Food, today: LocalDate): Boolean {
        val expirationDate = food.expirationDate?.let { LocalDate.parse(it) } ?: return false
        val limit = today.plusDays(3)
        return !expirationDate.isBefore(today) && !expirationDate.isAfter(limit)
    }
}