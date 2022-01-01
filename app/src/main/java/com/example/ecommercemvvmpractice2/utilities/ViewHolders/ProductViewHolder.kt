package com.example.ecommercemvvmpractice2.utilities.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.databinding.ProductCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener

class ProductViewHolder(private val productCardBinding: ProductCardBinding,val listner:itemClickListener) :
    RecyclerView.ViewHolder(productCardBinding.root) {

        fun bind (item:ProductResponse){
            productCardBinding.pName.text=item.title
            productCardBinding.pCategory.text=item.category
            productCardBinding.pPrice.text=item.price.toString()
        }
}