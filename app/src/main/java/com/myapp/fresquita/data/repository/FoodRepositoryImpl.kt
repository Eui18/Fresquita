package com.myapp.fresquita.data.repository

import com.myapp.fresquita.data.datasource.FoodSeedDataSource
import com.myapp.fresquita.data.model.Food

class FoodRepositoryImpl(
    private val dataSource: FoodSeedDataSource
) : FoodRepository {
    override fun getFoods(): List<Food> {
        return dataSource.getFoods()
    }
}