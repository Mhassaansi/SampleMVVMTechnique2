package com.example.ecommercemvvmpractice2.data.response

import com.google.gson.annotations.SerializedName


//data class LoginResponse(
//    val data: LoginData,
//    val status: Int,
//    val errorMsg: String?
//){}

data class LoginData(
    @SerializedName("token") var token: String? = null){}