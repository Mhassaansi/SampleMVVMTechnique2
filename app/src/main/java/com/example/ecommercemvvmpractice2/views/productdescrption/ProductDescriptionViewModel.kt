package com.example.ecommercemvvmpractice2.views.productdescrption

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.data.room.CartDao
import com.example.ecommercemvvmpractice2.networking.Repositories.local.CartItemsRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
class ProductDescriptionViewModel (
   // val cartDao: CartDao,
   private val cartItemsRepository: CartItemsRepository,
   // @Assisted private val state: SavedStateHandle
) : ViewModel() {

//    val cart = state.get<Cart>("cart")
//    var productName = state.get<String>("productName") ?: cart?.productName ?: ""
//        set(value) {
//            field = value
//            state.set("productName", value)
//        }
//
//    var productId = state.get<Int>("ProductId") ?: cart?.productId ?: 0
//        set(value) {
//            field = value
//            state.set("productId", value)
//        }
//
//    var productQuantity = state.get<Int>("productQauntity") ?: cart?.productQuantity ?: 0
//        set(value) {
//            field = value
//            state.set("productQauntity", value)
//        }
//
//
//    var productCategory = state.get<String>("productcategory") ?: cart?.productCategory ?: ""
//        set(value) {
//            field = value
//            state.set("productCategory", value)
//        }
//
//
@DelicateCoroutinesApi
fun saveCartElement(productName:String, productCategory:String, productId:Int, productQuantity:Int) {

        val newCart = Cart(
            productName = productName,
            productCategory = productCategory,
            productId = productId,
            productQuantity = productQuantity
        )

        createCartElement(newCart)

    }


    @DelicateCoroutinesApi
    private fun createCartElement(cart: Cart) = GlobalScope.launch {
     //   cartDao.insertIntoCart(cart)
        cartItemsRepository.insert(cart)

    }


}