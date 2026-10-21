package com.myapp.fresquita.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.screens.PantryItem
import com.myapp.fresquita.presentation.util.ExpirationStatus
import com.myapp.fresquita.presentation.util.getCategoryText

@Composable
fun PantryItemRow(
    item: PantryItem,
    onMarkAsConsumed: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.food.name)
            Text(
                text = stringResource(
                    R.string.pantry_quantity,
                    item.food.quantity,
                    item.food.unit
                )
            )
            Text(text = stringResource(getCategoryText(item.food.category)))

            val statusText = getStatusText(item.status)
            if (statusText != null) {
                Text(text = stringResource(statusText))
            }

            Button(onClick = onMarkAsConsumed) {
                Text(text = stringResource(R.string.pantry_mark_consumed))
            }
        }
    }
}

private fun getStatusText(status: ExpirationStatus): Int? {
    return when (status) {
        ExpirationStatus.VALID -> R.string.status_valid
        ExpirationStatus.EXPIRING_SOON -> R.string.status_expiring_soon
        ExpirationStatus.EXPIRED -> R.string.status_expired
        ExpirationStatus.NO_DATE -> null
    }
}