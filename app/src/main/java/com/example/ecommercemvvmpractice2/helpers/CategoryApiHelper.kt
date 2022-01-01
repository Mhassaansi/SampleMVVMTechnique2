package com.example.ecommercemvvmpractice2.helpers

import com.example.ecommercemvvmpractice2.data.response.CategoryData
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.networking.CategoriesRepository
import com.example.ecommercemvvmpractice2.utilities.constants.NetworkConstants
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CategoryApiHelper @Inject constructor(
    private val categoriesRepository:
    CategoriesRepository
) {

    suspend fun getCategoryList(): NetworkResponseData<List<String>> {
        return NetworkConstants.performRequest {
            runBlocking {
                categoriesRepository.category()
            }

        }
    }

}