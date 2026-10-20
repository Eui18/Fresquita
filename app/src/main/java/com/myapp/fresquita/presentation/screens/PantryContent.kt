package com.myapp.fresquita.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.components.PantryItemRow

@Composable
fun PantryContent(
    uiState: PantryUiState,
    onMarkAsConsumed: (String) -> Unit
) {
    Column(modifier = Modifier.statusBarsPadding()) {
        Text(text = stringResource(R.string.pantry_title))

        if (uiState.items.isEmpty()) {
            Text(text = stringResource(R.string.pantry_empty))
        } else {
            LazyColumn {
                items(uiState.items, key = { it.food.id }) { item ->
                    PantryItemRow(
                        item = item,
                        onMarkAsConsumed = { onMarkAsConsumed(item.food.id) }
                    )
                }
            }
        }
    }
}