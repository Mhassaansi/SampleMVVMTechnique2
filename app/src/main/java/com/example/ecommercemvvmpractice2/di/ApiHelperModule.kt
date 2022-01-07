package com.example.ecommercemvvmpractice2.di

import com.example.ecommercemvvmpractice2.helpers.AuthApiHelper
import com.example.ecommercemvvmpractice2.networking.Repositories.global.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module

class ApiHelperModule {
    @Provides
    fun provideAuthApiHelper(authRepository: AuthRepository):
            AuthApiHelper = AuthApiHelper(authRepository)
}