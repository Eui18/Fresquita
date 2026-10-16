package com.myapp.fresquita.di

import com.myapp.fresquita.data.datasource.FoodSeedDataSource
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.data.repository.FoodRepositoryImpl
import com.myapp.fresquita.presentation.viewmodel.HomeViewModelFactory

class AppModule {
    private val dataSource: FoodSeedDataSource by lazy {
        FoodSeedDataSource()
    }

    private val repository: FoodRepository by lazy {
        FoodRepositoryImpl(dataSource)
    }

    val homeViewModelFactory: HomeViewModelFactory by lazy {
        HomeViewModelFactory(repository)
    }
}