package com.myapp.fresquita.presentation.pantry.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.myapp.fresquita.FresquitaApplication
import com.myapp.fresquita.presentation.pantry.viewmodel.PantryViewModel

@Composable
fun PantryPage(
    onEditFood: (String) -> Unit,
    viewModel: PantryViewModel = viewModel(
        factory = (LocalContext.current.applicationContext as FresquitaApplication)
            .appModule.pantryViewModelFactory
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PantryContent(
        uiState = uiState,
        onMarkAsConsumed = { id -> viewModel.markAsConsumed(id) },
        onEditFood = onEditFood,
        onDeleteRequest = { id -> viewModel.onDeleteRequest(id)},
        onDeleteConfirm = { viewModel.onDeleteConfirm()},
        onDeleteCancel = { viewModel.onDeleteCancel()}
    )
}