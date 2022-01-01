package com.example.ecommercemvvmpractice2.networking

import javax.inject.Inject

class CategoriesRepository @Inject constructor(private val apiService: ApiService){

    suspend fun category()=apiService.getCategories()

}