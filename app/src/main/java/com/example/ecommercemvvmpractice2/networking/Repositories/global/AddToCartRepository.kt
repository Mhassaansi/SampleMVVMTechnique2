package com.example.ecommercemvvmpractice2.networking.Repositories.global

import com.example.ecommercemvvmpractice2.data.request.AddToCart
import com.example.ecommercemvvmpractice2.networking.ApiService
import javax.inject.Inject


class AddToCartRepository  @Inject constructor(private val apiService: ApiService){

    suspend fun addToCart(productBody:AddToCart)=apiService.addTocart(productBody)
}