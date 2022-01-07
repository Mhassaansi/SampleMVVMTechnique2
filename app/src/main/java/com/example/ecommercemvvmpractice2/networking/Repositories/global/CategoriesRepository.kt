package com.example.ecommercemvvmpractice2.networking.Repositories.global

import com.example.ecommercemvvmpractice2.networking.ApiService
import javax.inject.Inject

class CategoriesRepository @Inject constructor(private val apiService: ApiService){

    suspend fun category()=apiService.getCategories()

}