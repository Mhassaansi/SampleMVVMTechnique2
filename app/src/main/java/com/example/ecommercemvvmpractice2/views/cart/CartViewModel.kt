package com.example.ecommercemvvmpractice2.views.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommercemvvmpractice2.networking.Repositories.local.CartItemsRepository


//@HiltViewModel
class CartViewModel(
    private val cartItemsRepository: CartItemsRepository) : ViewModel() {

    var isLoading = MutableLiveData(false)

    fun getDataFromCart() = cartItemsRepository.getFromCart()


}