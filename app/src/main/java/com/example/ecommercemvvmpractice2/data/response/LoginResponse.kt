package com.example.ecommercemvvmpractice2.data.response

import com.google.gson.annotations.SerializedName


data class LoginData(
    @SerializedName("token") var token: String? = null){}