package com.example.ecommercemvvmpractice2.di

import com.example.ecommercemvvmpractice2.networking.ApiService
import com.example.ecommercemvvmpractice2.networking.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun providesAuthRepository(apiService: ApiService): AuthRepository = AuthRepository(apiService)
}