package com.example.ecommercemvvmpractice2.utilities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.databinding.ProductCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.utilities.ViewHolders.ProductViewHolder

class ProductAdapter(private val productList: List<ProductResponse>, val listner : itemClickListener) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productBinding =
            ProductCardBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return ProductViewHolder(productBinding,listner)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList.get(position))
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}