package com.myapp.fresquita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.myapp.fresquita.presentation.navigation.FresquitaApp
import com.myapp.fresquita.presentation.screens.PantryPage
import com.myapp.fresquita.ui.theme.FresquitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FresquitaTheme {
                FresquitaApp()
            }
        }
    }
}
