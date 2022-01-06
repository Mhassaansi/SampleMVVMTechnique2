package com.example.ecommercemvvmpractice2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercemvvmpractice2.databinding.CategoryCardBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.utilities.ViewHolders.CategoryViewHolders


class CategoryAdapter(val categoryList: List<String>, val listner: itemClickListener) :
    RecyclerView.Adapter<CategoryViewHolders>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolders {
        val adapterBinding =
            CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)
        return CategoryViewHolders(adapterBinding, listner)
    }

    override fun onBindViewHolder(holder: CategoryViewHolders, position: Int) {
        holder.bind(categoryList.get(position))

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

//    override fun getCategoryPos(pos:Int): Int {
//       pos=catName
//    }


}