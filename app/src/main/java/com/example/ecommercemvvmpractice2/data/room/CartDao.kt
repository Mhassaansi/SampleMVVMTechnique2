package com.example.ecommercemvvmpractice2.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow


@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoCart(cart:Cart)

    @Update
    fun updateIntoCart(cart: Cart)

    @Delete
    fun deleteintoCart(cart: Cart)

    @Query("SELECT * FROM cart_table")
    fun getAllDataFromCart():LiveData<List<Cart>>

//    fun getCartItems(): Flow<List<Cart>>={
//
//    }
}