package com.example.ecommercemvvmpractice2.helpers

import com.example.ecommercemvvmpractice2.data.request.Auth
import com.example.ecommercemvvmpractice2.data.response.LoginData
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.networking.Repositories.global.AuthRepository
import com.example.ecommercemvvmpractice2.utilities.constants.NetworkConstants
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AuthApiHelper @Inject constructor(private val authRepository: AuthRepository) {

    suspend fun login(loginCredentials: Auth): NetworkResponseData<LoginData> {
        return NetworkConstants.performRequest {
            runBlocking {
                authRepository.login(loginCredentials)
            }
        }
    }

}