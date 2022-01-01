package com.example.ecommercemvvmpractice2.helpers

import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.networking.ProductRepository
import com.example.ecommercemvvmpractice2.utilities.constants.NetworkConstants
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ProductApiHelper @Inject constructor(private val productRepository: ProductRepository){

    suspend fun getProductList(categoryName:String):NetworkResponseData<List<ProductResponse>>{
        return NetworkConstants.performRequest {
            runBlocking {
                productRepository.getProduct(categoryName)
            }
        }
    }
}