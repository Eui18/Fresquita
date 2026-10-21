package com.myapp.fresquita.data.repository

import com.myapp.fresquita.data.datasource.FoodLocalDataSource
import com.myapp.fresquita.data.datasource.FoodSeedDataSource
import com.myapp.fresquita.data.model.Food
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart

class FoodRepositoryImpl(
    private val seedDataSource: FoodSeedDataSource,
    private val localDataSource: FoodLocalDataSource
) : FoodRepository {

    override val foods: Flow<List<Food>> = localDataSource.foods.onStart {
        loadSeedIfNeeded()
    }

    override suspend fun markAsConsumed(id: String) {
        localDataSource.markAsConsumed(id)
    }

    override suspend fun addFood(food: Food) {
        localDataSource.addFood(food)
    }

    override suspend fun deleteFood(id: String) {
        localDataSource.deleteFood(id)
    }

    override suspend fun updateFood(food: Food) {
        localDataSource.updateFood(food)
    }

    override suspend fun getFoodById(id: String): Food? {
        return localDataSource.getFoodById(id)
    }

    private suspend fun loadSeedIfNeeded() {
        if (!localDataSource.isSeedLoaded()) {
            localDataSource.saveInitialFoods(seedDataSource.getFoods())
        }
    }
}