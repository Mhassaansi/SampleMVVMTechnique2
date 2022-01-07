package com.example.ecommercemvvmpractice2.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart_table")
data class Cart(
    @ColumnInfo(name="product_name")
    val productName: String? = null,
    @ColumnInfo(name="product_category")
    val productCategory: String? = null,
    @ColumnInfo(name="product_id")
    val productId: Int = 0,
    @ColumnInfo(name="product_quantity")
    val productQuantity: Int = 0,

){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}