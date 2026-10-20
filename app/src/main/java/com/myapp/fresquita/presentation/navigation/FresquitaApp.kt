package com.myapp.fresquita.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.myapp.fresquita.presentation.screens.HomePage
import com.myapp.fresquita.presentation.screens.PantryPage

@Composable
fun FresquitaApp() {
    var  currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }

    BackHandler (enabled = currentScreen != AppScreen.HOME) {
        currentScreen = AppScreen.HOME
    }

    when (currentScreen) {
        AppScreen.HOME -> HomePage(
            onOpenPantry = { currentScreen = AppScreen.PANTRY }
        )
        AppScreen.PANTRY -> PantryPage()
    }
}