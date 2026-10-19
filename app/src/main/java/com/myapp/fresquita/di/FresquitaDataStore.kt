package com.myapp.fresquita.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.fresquitaDataStore: DataStore<Preferences> by preferencesDataStore(name = "fresquita")