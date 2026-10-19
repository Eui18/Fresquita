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

    override val foods: Flow<List<Food>> = localDataSource.foods.onStart{
        loadSeedIfNeed()
    }

    private suspend fun loadSeedIfNeed() {
        if (!localDataSource.isSeedLoaded()) {
            localDataSource.saveInitialFoods(seedDataSource.getFoods())
        }
    }
}