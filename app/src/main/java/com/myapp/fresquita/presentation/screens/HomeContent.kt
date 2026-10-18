package com.myapp.fresquita.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.myapp.fresquita.R

@Composable
fun HomeContent(uiState: HomeUiState) {
    Column {
        Text(text = stringResource(R.string.home_title))
        Text(text = stringResource(R.string.home_available_label, uiState.availableCount))
        Text(text = stringResource(R.string.home_expiring_soon_label, uiState.expiringSoonCount))
    }
}