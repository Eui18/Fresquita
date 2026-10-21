package com.myapp.fresquita.presentation.pantry.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.presentation.common.formatQuantity
import com.myapp.fresquita.presentation.common.getCategoryText
import com.myapp.fresquita.presentation.pantry.state.PantryUiState
import com.myapp.fresquita.presentation.common.getExpirationStatus
import com.myapp.fresquita.presentation.common.getStatusText
import com.myapp.fresquita.presentation.pantry.state.PantryItemUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

class PantryViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PantryUiState())
    val uiState: StateFlow<PantryUiState> = _uiState.asStateFlow()

    init {
        observeFoods()
    }

    fun markAsConsumed(id: String) {
        viewModelScope.launch {
            repository.markAsConsumed(id)
        }
    }

    private fun observeFoods() {
        viewModelScope.launch {
            repository.foods.collect { foods ->
                updateItems(foods)
            }
        }
    }

    private fun updateItems(foods: List<Food>) {
        val today = LocalDate.now()
        val items = foods
            .filter { !it.isConsumed }
            .map { food -> createItem(food, today) }

        _uiState.update { it.copy(items = items) }
    }

    private fun createItem(food: Food, today: LocalDate): PantryItemUi {
        return PantryItemUi(
            id = food.id,
            name = food.name,
            quantity = formatQuantity(food.quantity),
            unit = food.unit,
            categoryText = getCategoryText(food.category),
            statusText = getStatusText(getExpirationStatus(food, today))
        )
    }
}
