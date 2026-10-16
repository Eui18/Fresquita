package com.myapp.fresquita.data.datasource

import com.myapp.fresquita.data.model.Food
import com.myapp.fresquita.data.model.FoodCategory

class FoodSeedDataSource {
    private val foods = listOf(
        Food(
            id = "seed-1",
            name = "Fresas",
            category = FoodCategory.FRUITS,
            quantity = 1.0,
            unit = "Caja",
            expirationDate = "2026-10-14",
            isConsumed = false,
            illustrationKey = "generic"
        ),
        Food(
            id = "seed-2",
            name = "Manzanas",
            category = FoodCategory.FRUITS,
            quantity = 4.0,
            unit = "Piezas",
            expirationDate = "2026-10-18",
            isConsumed = false,
            illustrationKey = "generic"
        ),
        Food(
            id = "seed-3",
            name = "Zanahorias",
            category = FoodCategory.VEGETABLES,
            quantity = 6.0,
            unit = "Piezas",
            expirationDate = "2026-10-16",
            isConsumed = false,
            illustrationKey = "generic"
        ),
        Food(
            id = "seed-4",
            name = "Leche",
            category = FoodCategory.REFRIGERATED,
            quantity = 1.0,
            unit = "Litro",
            expirationDate = "2026-10-13",
            isConsumed = false,
            illustrationKey = "generic"
        )
    )

    fun getFoods(): List<Food> = foods
}