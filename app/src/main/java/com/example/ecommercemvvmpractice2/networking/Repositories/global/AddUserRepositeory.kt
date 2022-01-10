package com.example.ecommercemvvmpractice2.networking.Repositories.global

import com.example.ecommercemvvmpractice2.networking.ApiService
import om.example.ecommercemvvmpractice2.data.AddUsers
import javax.inject.Inject

class AddUserRepositeory @Inject constructor(private val apiService:ApiService) {

    suspend fun addUsers(addUsers: AddUsers)=apiService.addUsers(addUsers)
}