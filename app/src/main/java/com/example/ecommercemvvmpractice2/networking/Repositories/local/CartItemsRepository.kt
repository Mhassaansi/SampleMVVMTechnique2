package com.example.ecommercemvvmpractice2.networking.Repositories.local

import com.example.ecommercemvvmpractice2.data.room.Cart

class CartItemsRepository(private val db: CartItemsRepository) {

    suspend fun delete(cart: Cart) = db.cartDao().deleteintoCart(cart)
    suspend fun insert(cart: Cart) = db.cartDao().insertIntoCart(cart)
    suspend fun update(cart: Cart) = db.cartDao().updateIntoCart(cart)
    fun getFromCart() = db.cartDao().getAllDataFromCart()
}