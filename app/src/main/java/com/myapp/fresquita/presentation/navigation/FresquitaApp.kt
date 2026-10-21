package com.myapp.fresquita.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapp.fresquita.presentation.form.screen.FoodFormPage
import com.myapp.fresquita.presentation.home.screen.HomePage
import com.myapp.fresquita.presentation.pantry.screen.PantryPage

@Composable
fun FresquitaApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AppScreen.HOME) }
    var editingFoodId by rememberSaveable { mutableStateOf<String?>(null) }

    BackHandler(enabled = currentScreen != AppScreen.HOME) {
        currentScreen = if (currentScreen == AppScreen.FORM) AppScreen.PANTRY else AppScreen.HOME
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
        bottomBar = {
            if (currentScreen != AppScreen.FORM) {
                AppBottomBar(
                    currentScreen = currentScreen,
                    onHomeClick = { currentScreen = AppScreen.HOME },
                    onAddClick = {
                        editingFoodId = null
                        currentScreen = AppScreen.FORM
                    },
                    onPantryClick = { currentScreen = AppScreen.PANTRY }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                AppScreen.HOME -> HomePage(
                    onOpenPantry = { currentScreen = AppScreen.PANTRY }
                )

                AppScreen.PANTRY -> PantryPage(
                    onEditFood = { id ->
                        editingFoodId = id
                        currentScreen = AppScreen.FORM
                    }
                )

                AppScreen.FORM -> FoodFormPage(
                    foodId = editingFoodId,
                    onFinished = { currentScreen = AppScreen.PANTRY }
                )
            }
        }
    }
}