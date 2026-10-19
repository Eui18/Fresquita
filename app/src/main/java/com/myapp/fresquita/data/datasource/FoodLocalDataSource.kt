package com.myapp.fresquita.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.myapp.fresquita.data.model.Food
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class FoodLocalDataSource(
    private val dataStore: DataStore<Preferences>
) {
    private val foodsKey = stringPreferencesKey("foods")
    private val seedLoadedKey = booleanPreferencesKey("seed_loaded")

    val foods: Flow<List<Food>> = dataStore.data.map { preferences ->
        val json = preferences[foodsKey]
        if (json == null) emptyList() else Json.decodeFromString<List<Food>>(json)
    }

    suspend fun isSeedLoaded(): Boolean {
        return dataStore.data.first()[seedLoadedKey] ?: false
    }

    suspend fun saveInitialFoods(foods: List<Food>) {
        dataStore.edit { preferences ->
            preferences[foodsKey] = Json.encodeToString(foods)
            preferences[seedLoadedKey] = true
        }
    }
}