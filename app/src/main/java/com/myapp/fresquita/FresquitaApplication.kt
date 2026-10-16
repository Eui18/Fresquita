package com.myapp.fresquita

import android.app.Application
import com.myapp.fresquita.di.AppModule

class FresquitaApplication : Application() {
    val appModule: AppModule by lazy {
        AppModule()
    }
}