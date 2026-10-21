package com.myapp.fresquita.presentation.pantry.components

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
import com.myapp.fresquita.presentation.pantry.state.PantryItemUi

@Composable
fun PantryItemRow(
    item: PantryItemUi,
    onMarkAsConsumed: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name)
            Text(
                text = stringResource(
                    R.string.pantry_quantity,
                    item.quantity,
                    item.unit
                )
            )
            Text(text = stringResource(item.categoryText))

            if (item.statusText != null) {
                Text(text = stringResource(item.statusText))
            }

            Button(onClick = onMarkAsConsumed) {
                Text(text = stringResource(R.string.pantry_mark_consumed))
            }
        }
    }
}
