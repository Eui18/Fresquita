package com.myapp.fresquita.data.datasource

import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.model.FoodCategory
import com.myapp.fresquita.data.model.GENERIC_ILLUSTRATION_KEY
import java.time.LocalDate

class FoodSeedDataSource {
    fun getFoods(): List<Food> = listOf(
        Food(
            id = "seed-1",
            name = "Fresas",
            category = FoodCategory.FRUITS,
            quantity = 1.0,
            unit = "Caja",
            expirationDate = daysFromToday(2),
            isConsumed = false,
            illustrationKey = GENERIC_ILLUSTRATION_KEY
        ),
        Food(
            id = "seed-2",
            name = "Manzanas",
            category = FoodCategory.FRUITS,
            quantity = 4.0,
            unit = "Piezas",
            expirationDate = daysFromToday(8),
            isConsumed = false,
            illustrationKey = GENERIC_ILLUSTRATION_KEY
        ),
        Food(
            id = "seed-3",
            name = "Zanahorias",
            category = FoodCategory.VEGETABLES,
            quantity = 6.0,
            unit = "Piezas",
            expirationDate = daysFromToday(5),
            isConsumed = false,
            illustrationKey = GENERIC_ILLUSTRATION_KEY
        ),
        Food(
            id = "seed-4",
            name = "Leche",
            category = FoodCategory.REFRIGERATED,
            quantity = 1.0,
            unit = "Litro",
            expirationDate = daysFromToday(1),
            isConsumed = false,
            illustrationKey = GENERIC_ILLUSTRATION_KEY
        )
    )

    private fun daysFromToday(days: Long): String =
        LocalDate.now().plusDays(days).toString()
}