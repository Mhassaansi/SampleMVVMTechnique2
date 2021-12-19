package com.example.ecommercemvvmpractice2

import android.app.Application
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class MainAppClass  : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}