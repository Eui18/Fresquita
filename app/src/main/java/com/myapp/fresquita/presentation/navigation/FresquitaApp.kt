package com.myapp.fresquita.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.myapp.fresquita.presentation.form.screen.FoodFormPage
import com.myapp.fresquita.presentation.home.screen.HomePage
import com.myapp.fresquita.presentation.pantry.screen.PantryPage

@Composable
fun FresquitaApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }

    BackHandler(enabled = currentScreen != AppScreen.HOME) {
        currentScreen = if (currentScreen == AppScreen.FORM) AppScreen.PANTRY else AppScreen.HOME
    }

    when (currentScreen) {
        AppScreen.HOME -> HomePage(
            onOpenPantry = { currentScreen = AppScreen.PANTRY }
        )
        AppScreen.PANTRY -> PantryPage(
            onAddFood = { currentScreen = AppScreen.FORM }
        )

        AppScreen.FORM -> FoodFormPage(
            onFinished = { currentScreen = AppScreen.PANTRY }
        )
    }
}