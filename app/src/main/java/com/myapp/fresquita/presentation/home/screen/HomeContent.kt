package com.myapp.fresquita.presentation.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.common.components.ScreenHeader
import com.myapp.fresquita.presentation.common.components.SecondaryButton
import com.myapp.fresquita.presentation.home.components.ExpiringFoodCard
import com.myapp.fresquita.presentation.home.components.SummaryCard
import com.myapp.fresquita.presentation.home.state.HomeUiState

@Composable
fun HomeContent(
    uiState: HomeUiState,
    onOpenPantry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ScreenHeader(
            title = stringResource(R.string.home_greeting),
            subtitle = stringResource(R.string.home_subtitle)
        )

        Text(
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            SummaryCard(
                count = uiState.availableCount,
                label = stringResource(R.string.home_available_label),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.weight(1f)
            )
            SummaryCard(
                count = uiState.expiringSoonCount,
                label = stringResource(R.string.home_expiring_soon_label),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = stringResource(R.string.home_expiring_title),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        if (uiState.expiringItems.isEmpty()) {
            Text(
                text = stringResource(R.string.home_no_expiring),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(uiState.expiringItems, key = { it.id }) { item ->
                    ExpiringFoodCard(item = item)
                }
            }
        }

        SecondaryButton(
            text = stringResource(R.string.home_open_pantry),
            onClick = onOpenPantry
        )
    }
}