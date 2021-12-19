package com.example.ecommercemvvmpractice2.data.response


data class LoginResponse(
    val data: LoginData,
    val status: Int,
    val errorMsg: String?
){}

data class LoginData(var token: String){}