package com.example.ecommercemvvmpractice2.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart_table")
data class Cart(
    val productName: String? = null,
    val productCategory: String? = null,
    val productId: Int = 0,
    val productQuantity: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)