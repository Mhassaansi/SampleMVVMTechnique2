package com.example.ecommercemvvmpractice2.views.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.room.CartDao
import com.example.ecommercemvvmpractice2.networking.Repositories.local.CartItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
class CartViewModel (
    //cartDao: CartDao
private val cartItemsRepository: CartItemsRepository
):ViewModel() {

    var isLoading=MutableLiveData(false)

fun getDataFromCart()=cartItemsRepository.getFromCart()




}