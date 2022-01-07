package com.example.ecommercemvvmpractice2.data.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommercemvvmpractice2.networking.Repositories.local.CartItemsRepository
import com.example.ecommercemvvmpractice2.views.cart.CartViewModel

class CartViewModelFactory(private val cartItemsRepository: CartItemsRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      //  return super.create(modelClass)

        return CartViewModel(cartItemsRepository) as T
    }
    //https://www.geeksforgeeks.org/how-to-build-a-grocery-android-app-using-mvvm-and-room-database/
}