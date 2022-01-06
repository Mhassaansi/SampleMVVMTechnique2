package com.example.ecommercemvvmpractice2.utilities.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.databinding.CartCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener

class CartViewHolder(private val cardBinding: CartCardBinding,val listener:itemClickListener) :
    RecyclerView.ViewHolder(cardBinding.root) {

         fun bind(item:String){
             cardBinding.cartProdName.text=item
             cardBinding.cartProdPrice.text=item
             cardBinding.cartProdQuantity.text=item

             cardBinding.increaseProduct.setOnClickListener {


             }
             cardBinding.decreaseProduct.setOnClickListener {



             }
         }



}