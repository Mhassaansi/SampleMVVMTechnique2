package com.example.ecommercemvvmpractice2.networking

import com.example.ecommercemvvmpractice2.data.request.Auth
import com.example.ecommercemvvmpractice2.data.response.LoginResponse
import com.example.ecommercemvvmpractice2.utilities.constants.AuthEndpoints
import retrofit2.http.Body
import retrofit2.http.POST

interface  ApiService {


    @POST(AuthEndpoints.authLogin)
    suspend fun login(@Body loginCredentials: Auth): LoginResponse


}