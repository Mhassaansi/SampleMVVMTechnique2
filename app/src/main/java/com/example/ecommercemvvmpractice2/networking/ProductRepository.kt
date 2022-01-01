package com.example.ecommercemvvmpractice2.networking

import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService){

suspend fun getProduct(categoryName:String)=apiService.getProductsByCategories(categoryName)
}