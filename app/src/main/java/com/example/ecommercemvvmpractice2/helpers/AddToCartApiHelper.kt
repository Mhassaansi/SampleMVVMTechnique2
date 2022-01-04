package com.example.ecommercemvvmpractice2.helpers

import com.example.ecommercemvvmpractice2.data.request.AddToCart
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.networking.AddToCartRepository
import com.example.ecommercemvvmpractice2.utilities.constants.NetworkConstants
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AddToCartApiHelper @Inject constructor(private val addToCartRepository: AddToCartRepository) {

    suspend fun addtocart(productBody: AddToCart): NetworkResponseData<AddToCart> {
        return NetworkConstants.performRequest {
            runBlocking {
                addToCartRepository.addToCart(productBody)
            }

        }
    }
}