package com.myapp.fresquita.data.repository

import com.myapp.fresquita.data.model.Food

interface FoodRepository {
    fun getFoods(): List<Food>
}