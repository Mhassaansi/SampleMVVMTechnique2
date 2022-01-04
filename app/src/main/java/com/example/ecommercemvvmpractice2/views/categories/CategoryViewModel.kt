package com.example.ecommercemvvmpractice2.views.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.helpers.CategoryApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryApiHelper: CategoryApiHelper
) : ViewModel() {
    var isLoading = MutableLiveData(false)
    private val categoryResponse = MutableLiveData<NetworkResponseData<List<String>>>()

    fun providesCategoryResponse(): LiveData<NetworkResponseData<List<String>>> {

        categoryResponse.postValue(NetworkResponseData.Loading())

        viewModelScope.launch(Dispatchers.IO) {
            categoryResponse.postValue(categoryApiHelper.getCategoryList())
        }
        return categoryResponse
    }


}