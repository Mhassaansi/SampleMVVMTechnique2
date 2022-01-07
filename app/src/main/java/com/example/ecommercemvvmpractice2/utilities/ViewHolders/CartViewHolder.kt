package com.example.ecommercemvvmpractice2.utilities.ViewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.databinding.CartCardBinding

class CartViewHolder(private val cardBinding: CartCardBinding) :
    RecyclerView.ViewHolder(cardBinding.root) {

    var count = 0
    var updatedPrice = 0

    fun bind(item: Cart) {
        cardBinding.cartProdName.text = item.toString()
        cardBinding.cartProdPrice.text = item.toString()
        cardBinding.cartProdQuantity.text = item.toString()




        cardBinding.increaseProduct.setOnClickListener {
            count = (cardBinding.cartProdQuantity.text.toString()).toInt()
            count++
            cardBinding.cartProdQuantity.text = count.toString()

            updatedPrice=(count)*(cardBinding.cartProdPrice.text.toString().toInt())


        }

        cardBinding.decreaseProduct.setOnClickListener {
            if ((cardBinding.cartProdQuantity.text as String).toInt() <= 0) {
                cardBinding.cartProdQuantity.text = count.toString()
            } else {
                count = cardBinding.cartProdQuantity.text.toString().toInt()
                count--
                cardBinding.cartProdQuantity.text = count.toString()
                updatedPrice=(count)*(cardBinding.cartProdPrice.text.toString().toInt())
            }


        }
    }


}