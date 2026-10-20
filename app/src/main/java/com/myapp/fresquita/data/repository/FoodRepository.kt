package com.myapp.fresquita.data.repository

import com.myapp.fresquita.data.model.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    val foods: Flow<List<Food>>
    suspend fun markAsConsumed(id: String)
}