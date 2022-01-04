package com.example.ecommercemvvmpractice2.views.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor():ViewModel() {

    var isLoading=MutableLiveData(false)


    fun addToCart(){

    }


}