package com.example.ecommercemvvmpractice2.data.response

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCategory: DiffUtil.ItemCallback<CategoryData>() {
    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
       return newItem.category==oldItem.category
    }

    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return newItem==oldItem
        return oldItem.equals(newItem)
    }

}