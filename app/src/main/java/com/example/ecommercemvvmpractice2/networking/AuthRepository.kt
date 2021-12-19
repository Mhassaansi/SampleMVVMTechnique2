package com.example.ecommercemvvmpractice2.networking

import com.example.ecommercemvvmpractice2.data.request.Auth
import javax.inject.Inject


class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginCredentials: Auth)=apiService.login(loginCredentials)

}