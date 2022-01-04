package com.example.ecommercemvvmpractice2.data.request

import com.google.gson.annotations.SerializedName


data class AddToCart(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("userId") var userId: Int? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf()

)