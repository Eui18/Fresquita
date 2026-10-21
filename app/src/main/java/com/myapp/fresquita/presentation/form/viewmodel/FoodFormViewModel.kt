package com.myapp.fresquita.presentation.form.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.model.FoodCategory
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.presentation.form.state.FoodFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.util.UUID

private const val GENERIC_ILLUSTRATION = "generic"

class FoodFormViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(FoodFormUiState())
    val uiState: StateFlow<FoodFormUiState> = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update { it.copy(name = name, nameError = false) }
    }

    fun onCategoryChange(category: FoodCategory) {
        _uiState.update { it.copy(category = category) }
    }

    fun onQuantityChange(quantity: String) {
        _uiState.update { it.copy(quantity = quantity, quantityError = false) }
    }

    fun onUnitChange(unit: String) {
        _uiState.update { it.copy(unit = unit, unitError = false) }
    }

    fun onExpirationDateChange(date: String) {
        _uiState.update { it.copy(expirationDate = date, dateError = false) }
    }

    fun saveFood() {
        val state = _uiState.value
        val quantity = state.quantity.replace(',', '.').toDoubleOrNull() ?: 0.0
        val hasNameError = state.name.isBlank()
        val hasQuantityError = quantity <= 0.0
        val hasUnitError = state.unit.isBlank()
        val hasDateError = state.expirationDate.isNotBlank() &&
                !isValidDate(state.expirationDate.trim())

        if (hasNameError || hasQuantityError || hasUnitError || hasDateError) {
            _uiState.update {
                it.copy(
                    nameError = hasNameError,
                    quantityError = hasQuantityError,
                    unitError = hasUnitError,
                    dateError = hasDateError
                )
            }
            return
        }

        val food = createFood(state, quantity)

        viewModelScope.launch {
            repository.addFood(food)
            _uiState.update { it.copy(isSaved = true) }
        }
    }

    fun resetForm() {
        _uiState.update { FoodFormUiState() }
    }

    private fun isValidDate(date: String): Boolean {
        return try {
            LocalDate.parse(date)
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    private fun createFood(state: FoodFormUiState, quantity: Double): Food {
        return Food(
            id = UUID.randomUUID().toString(),
            name = state.name.trim(),
            category = state.category,
            quantity = quantity,
            unit = state.unit.trim(),
            expirationDate = state.expirationDate.trim().ifBlank { null },
            isConsumed = false,
            illustrationKey = GENERIC_ILLUSTRATION
        )
    }
}