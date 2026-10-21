package com.myapp.fresquita.presentation.common

import com.myapp.fresquita.data.model.Food
import java.time.LocalDate

data class FoodItemUi(
    val id: String,
    val name: String,
    val quantity: String,
    val unit: String,
    val categoryText: Int,
    val emoji: Int,
    val status: ExpirationStatus,
    val statusText: Int?,
    val expirationDate: String?
)

fun createFoodItemUi(food: Food, today: LocalDate): FoodItemUi {
    val status = getExpirationStatus(food, today)
    return FoodItemUi(
        id = food.id,
        name = food.name,
        quantity = formatQuantity(food.quantity),
        unit = food.unit,
        categoryText = getCategoryText(food.category),
        emoji = getCategoryEmoji(food.category),
        status = status,
        statusText = getStatusText(status),
        expirationDate = food.expirationDate
    )
}