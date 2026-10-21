package com.myapp.fresquita.presentation.pantry.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.common.components.ScreenHeader
import com.myapp.fresquita.presentation.pantry.components.DeleteConfirmDialog
import com.myapp.fresquita.presentation.pantry.components.PantryItemRow
import com.myapp.fresquita.presentation.pantry.state.PantryUiState

@Composable
fun PantryContent(
    uiState: PantryUiState,
    onMarkAsConsumed: (String) -> Unit,
    onEditFood: (String) -> Unit,
    onDeleteRequest: (String) -> Unit,
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        ScreenHeader(
            title = stringResource(R.string.pantry_title),
            subtitle = stringResource(R.string.pantry_subtitle)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (uiState.items.isEmpty()) {
            Text(
                text = stringResource(R.string.pantry_empty),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(uiState.items, key = { it.id }) { item ->
                    PantryItemRow(
                        item = item,
                        onMarkAsConsumed = { onMarkAsConsumed(item.id) },
                        onEdit = { onEditFood(item.id) },
                        onDelete = { onDeleteRequest(item.id) }
                    )
                }
            }
        }
    }

    if (uiState.foodToDeleteId != null) {
        DeleteConfirmDialog(
            onConfirm = onDeleteConfirm,
            onCancel = onDeleteCancel
        )
    }
}