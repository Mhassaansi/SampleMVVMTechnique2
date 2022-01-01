package com.example.ecommercemvvmpractice2.networking

import com.example.ecommercemvvmpractice2.data.request.Auth
import com.example.ecommercemvvmpractice2.data.response.LoginResponse
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.utilities.constants.ApisEndpoints
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @POST(ApisEndpoints.authLogin)
    suspend fun login(@Body loginCredentials: Auth): LoginResponse

    @GET(ApisEndpoints.category)
    suspend fun getCategories(): MutableList<String>

    @GET(ApisEndpoints.products + "{CategoryName}")
    suspend fun getProductsByCategories(@Path("CategoryName") categoryName: String):
            List<ProductResponse>

}