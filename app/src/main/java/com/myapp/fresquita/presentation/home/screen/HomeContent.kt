package com.myapp.fresquita.presentation.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.home.state.HomeUiState

@Composable
fun HomeContent(
    uiState: HomeUiState,
    onOpenPantry: () -> Unit
) {
    Column(modifier = Modifier.statusBarsPadding()) {
        Text(text = stringResource(R.string.home_title))
        Text(text = stringResource(R.string.home_available_label, uiState.availableCount))
        Text(text = stringResource(R.string.home_expiring_soon_label, uiState.expiringSoonCount))
        Button(onClick = onOpenPantry) {
            Text(text = stringResource(R.string.home_open_pantry))
        }
    }
}