package com.example.ecommercemvvmpractice2.views.productdescrption

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.data.room.CartDao
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductDescriptionViewModel @Inject constructor(
    val cartDao: CartDao,
    @Assisted private val state: SavedStateHandle
) : ViewModel() {

    val cart = state.get<Cart>("cart")
    var productName = state.get<String>("productName") ?: cart?.productName ?: ""
        set(value) {
            field = value
            state.set("productName", value)
        }

    var productId = state.get<Int>("ProductId") ?: cart?.productId ?: 0
        set(value) {
            field = value
            state.set("productId", value)
        }

    var productQuantity = state.get<Int>("productQauntity") ?: cart?.productQuantity ?: 0
        set(value) {
            field = value
            state.set("productQauntity", value)
        }


    var productCategory = state.get<String>("productcategory") ?: cart?.productCategory ?: ""
        set(value) {
            field = value
            state.set("productCategory", value)
        }


    fun saveCartElement() {

        val newCart = Cart(
            productName = productName,
            productCategory = productCategory,
            productId = productId,
            productQuantity = productQuantity
        )

        createCartElement(newCart)

    }

    private fun createCartElement(cart: Cart) = viewModelScope.launch {
        cartDao.insertIntoCart(cart)

    }


}