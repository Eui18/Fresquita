package com.myapp.fresquita.presentation.util

import com.myapp.fresquita.data.model.Food
import java.time.LocalDate

private const val EXPIRING_SOON_DAYS = 3L

enum class ExpirationStatus {
    VALID,
    EXPIRING_SOON,
    EXPIRED,
    NO_DATE
}

fun getExpirationStatus(food: Food, today: LocalDate): ExpirationStatus {
    if (food.expirationDate == null) {
        return ExpirationStatus.NO_DATE
    }

    val expirationDate = LocalDate.parse(food.expirationDate)
    val limit = today.plusDays(EXPIRING_SOON_DAYS)

    if (expirationDate.isBefore(today)) {
        return ExpirationStatus.EXPIRED
    }
    if (expirationDate.isAfter(limit)) {
        return ExpirationStatus.VALID
    }
    return ExpirationStatus.EXPIRING_SOON
}