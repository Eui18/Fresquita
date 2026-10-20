package com.myapp.fresquita.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.presentation.screens.HomeUiState
import com.myapp.fresquita.presentation.util.ExpirationStatus
import com.myapp.fresquita.presentation.util.getExpirationStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class HomeViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        observeFoods()
    }

    private fun observeFoods() {
        viewModelScope.launch {
            repository.foods.collect { foods ->
                updateSummary(foods)
            }
        }
    }

    private fun updateSummary(foods: List<Food>) {
        val availableFoods = foods.filter { !it.isConsumed }
        val today = LocalDate.now()
        val expiringSoon = availableFoods.count {
            getExpirationStatus(it, today) == ExpirationStatus.EXPIRING_SOON
        }

        _uiState.update {
            it.copy(
                availableCount = availableFoods.size,
                expiringSoonCount = expiringSoon
            )
        }
    }
}