package com.myapp.fresquita.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.common.FoodItemUi
import com.myapp.fresquita.presentation.common.components.FoodIllustration
import com.myapp.fresquita.presentation.common.components.StatusChip

@Composable
fun ExpiringFoodCard(
    item: FoodItemUi,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = modifier.width(180.dp)
    ) {
        FoodIllustration(
            emoji = stringResource(item.emoji),
            emojiSize = 48.sp,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(
                    R.string.food_subtitle,
                    item.quantity,
                    item.unit,
                    stringResource(item.categoryText)
                ),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (item.statusText != null) {
                StatusChip(
                    status = item.status,
                    statusText = item.statusText,
                    expirationDate = item.expirationDate,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}