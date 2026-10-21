package com.myapp.fresquita.presentation.home.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.myapp.fresquita.FresquitaApplication
import com.myapp.fresquita.presentation.home.viewmodel.HomeViewModel

@Composable
fun HomePage(
    onOpenPantry: () -> Unit,
    viewModel: HomeViewModel = viewModel(
        factory = (LocalContext.current.applicationContext as FresquitaApplication)
            .appModule.homeViewModelFactory
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeContent(
        uiState = uiState,
        onOpenPantry = onOpenPantry
    )
}