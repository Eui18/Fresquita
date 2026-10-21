package com.myapp.fresquita.presentation.form.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.data.model.FoodCategory
import com.myapp.fresquita.presentation.common.getCategoryText

@Composable
fun CategorySelector(
    selected: FoodCategory,
    onSelected: (FoodCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FoodCategory.entries.forEach { category ->
            FilterChip(
                selected = category == selected,
                onClick = { onSelected(category) },
                label = { Text(text = stringResource(getCategoryText(category))) }
            )
        }
    }
}