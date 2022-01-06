package com.example.ecommercemvvmpractice2.data.room

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

//    fun getCartItems(): Flow<List<Cart>>={
//
//    }
}