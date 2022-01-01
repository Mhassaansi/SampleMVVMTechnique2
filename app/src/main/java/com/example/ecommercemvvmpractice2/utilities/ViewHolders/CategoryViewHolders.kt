package com.example.ecommercemvvmpractice2.utilities.ViewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.databinding.CategoryCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener

class CategoryViewHolders(private val cardBinding: CategoryCardBinding, val listener:itemClickListener):
    RecyclerView.ViewHolder(cardBinding.root) {
        fun bind(item: String){
            cardBinding.catCardTextid.text=item
            cardBinding.root.setOnClickListener{
                listener.getItemPosition(absoluteAdapterPosition)
            }
        }



}