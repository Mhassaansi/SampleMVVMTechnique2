package com.example.ecommercemvvmpractice2.networking.Repositories.global

import com.example.ecommercemvvmpractice2.data.request.Auth
import com.example.ecommercemvvmpractice2.networking.ApiService
import javax.inject.Inject


class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginCredentials: Auth)=apiService.login(loginCredentials)

}