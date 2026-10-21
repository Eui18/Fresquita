package com.myapp.fresquita.presentation.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.R
import com.myapp.fresquita.presentation.common.ExpirationStatus
import com.myapp.fresquita.ui.theme.ChipGreenBg
import com.myapp.fresquita.ui.theme.ChipGreenText
import com.myapp.fresquita.ui.theme.ChipRedBg
import com.myapp.fresquita.ui.theme.ChipRedText
import com.myapp.fresquita.ui.theme.ChipYellowBg
import com.myapp.fresquita.ui.theme.ChipYellowText

@Composable
fun StatusChip(
    status: ExpirationStatus,
    statusText: Int,
    expirationDate: String?,
    modifier: Modifier = Modifier
) {
    var backgroundColor: Color = ChipGreenBg
    var textColor: Color = ChipGreenText

    if (status == ExpirationStatus.EXPIRING_SOON) {
        backgroundColor = ChipYellowBg
        textColor = ChipYellowText
    }
    if (status == ExpirationStatus.EXPIRED) {
        backgroundColor = ChipRedBg
        textColor = ChipRedText
    }

    val statusLabel = stringResource(statusText)
    val text = if (expirationDate == null) {
        statusLabel
    } else {
        stringResource(R.string.status_with_date, statusLabel, expirationDate)
    }

    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(50),
        modifier = modifier
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}