package com.example.ecommercemvvmpractice2.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.utilities.ViewHolders.CartViewHolder

class CartAdapter (val cartList : List<Cart>,listener: itemClickListener):
    RecyclerView.Adapter<CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
     holder.bi
    }

    override fun getItemCount(): Int {
     return cartList.size
    }

}