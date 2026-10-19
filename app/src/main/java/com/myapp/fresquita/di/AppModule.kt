package com.myapp.fresquita.di

import android.content.Context
import com.myapp.fresquita.data.datasource.FoodLocalDataSource
import com.myapp.fresquita.data.datasource.FoodSeedDataSource
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.data.repository.FoodRepositoryImpl
import com.myapp.fresquita.presentation.viewmodel.HomeViewModelFactory

class AppModule(private val context: Context) {

    private val SeedDataSource: FoodSeedDataSource by lazy {
        FoodSeedDataSource()
    }

    private val localDataSource: FoodLocalDataSource by lazy {
        FoodLocalDataSource(context.fresquitaDataStore)
    }

    private val repository: FoodRepository by lazy {
        FoodRepositoryImpl(SeedDataSource, localDataSource)
    }

    val homeViewModelFactory: HomeViewModelFactory by lazy {
        HomeViewModelFactory(repository)
    }
}