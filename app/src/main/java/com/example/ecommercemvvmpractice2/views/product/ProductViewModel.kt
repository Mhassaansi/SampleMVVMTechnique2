package com.example.ecommercemvvmpractice2.views.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.helpers.ProductApiHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productApiHelper: ProductApiHelper
) : ViewModel() {


    private var mutableProductData = MutableLiveData<NetworkResponseData<List<ProductResponse>>>()

    fun getProductData(category: String): LiveData<NetworkResponseData<List<ProductResponse>>> {

        viewModelScope.launch(Dispatchers.IO) {
            mutableProductData.postValue(productApiHelper.getProductList(category))
        }
        return mutableProductData
    }


}