package com.myapp.fresquita.presentation.form.screen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.myapp.fresquita.FresquitaApplication
import com.myapp.fresquita.presentation.form.viewmodel.FoodFormViewModel

@Composable
fun FoodFormPage(
    foodId: String?,
    onFinished: () -> Unit,
    viewModel: FoodFormViewModel = viewModel(
        factory = (LocalContext.current.applicationContext as FresquitaApplication)
            .appModule.foodFormViewModelFactory
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(foodId) {
       viewModel.loadFood(foodId)
    }

    LaunchedEffect(uiState.isSaved) {
        if (uiState.isSaved) {
            viewModel.resetForm()
            onFinished()
        }
    }

    BackHandler {
        viewModel.resetForm()
        onFinished()
    }

    FoodFormContent(
        uiState = uiState,
        onNameChange = { viewModel.onNameChange(it) },
        onCategoryChange = { viewModel.onCategoryChange(it) },
        onQuantityChange = { viewModel.onQuantityChange(it) },
        onUnitChange = { viewModel.onUnitChange(it) },
        onExpirationDateChange = { viewModel.onExpirationDateChange(it) },
        onSave = { viewModel.saveFood() },
        onCancel = {
            viewModel.resetForm()
            onFinished()
        }
    )
}