package com.myapp.fresquita.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val FresquitaColors = lightColorScheme(
    primary = Cherry,
    onPrimary = Color.White,
    secondaryContainer = RoseBg,
    onSecondaryContainer = Cherry,
    tertiaryContainer = Butter,
    onTertiaryContainer = Ink,
    background = Cream,
    onBackground = Ink,
    surface = Color.White,
    onSurface = Ink,
    onSurfaceVariant = SoftText,
    surfaceContainer = Color.White,
    surfaceContainerHigh = Color.White,
    outline = Blush,
    error = Cherry
)

@Composable
fun FresquitaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = FresquitaColors,
        typography = Typography,
        content = content
    )
}