package com.example.ecommercemvvmpractice2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.databinding.CartCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.utilities.ViewHolders.CartViewHolder

class CartAdapter (val cartList : List<Cart>):
    RecyclerView.Adapter<CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
       val adapterCart=CartCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(adapterCart)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
     holder.bind(cartList.get(position))
    }

    override fun getItemCount(): Int {
     return cartList.size
    }

}