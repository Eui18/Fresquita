package com.myapp.fresquita.di

import android.content.Context
import com.myapp.fresquita.data.datasource.FoodLocalDataSource
import com.myapp.fresquita.data.datasource.FoodSeedDataSource
import com.myapp.fresquita.data.repository.FoodRepository
import com.myapp.fresquita.data.repository.FoodRepositoryImpl
import com.myapp.fresquita.presentation.form.viewmodel.FoodFormViewModelFactory
import com.myapp.fresquita.presentation.home.viewmodel.HomeViewModelFactory
import com.myapp.fresquita.presentation.pantry.viewmodel.PantryViewModelFactory

class AppModule(private val context: Context) {

    private val seedDataSource: FoodSeedDataSource by lazy {
        FoodSeedDataSource()
    }

    private val localDataSource: FoodLocalDataSource by lazy {
        FoodLocalDataSource(context.fresquitaDataStore)
    }

    private val repository: FoodRepository by lazy {
        FoodRepositoryImpl(seedDataSource, localDataSource)
    }

    val homeViewModelFactory: HomeViewModelFactory by lazy {
        HomeViewModelFactory(repository)
    }

    val pantryViewModelFactory: PantryViewModelFactory by lazy {
        PantryViewModelFactory(repository)
    }

    val foodFormViewModelFactory: FoodFormViewModelFactory by lazy {
        FoodFormViewModelFactory(repository)
    }
}