package com.example.ecommercemvvmpractice2.views.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.databinding.CategoryBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.utilities.adapters.CategoryAdapter
import com.example.ecommercemvvmpractice2.utilities.constants.StringConstants
import com.example.ecommercemvvmpractice2.utilities.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoryFragment : Fragment(),itemClickListener {
     private lateinit var cateogaryList:MutableList<String>
    private val categoryViewModel by viewModels<CategoryViewModel>()
    private lateinit var categoryBinding: CategoryBinding

     private var categroryName:String?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        categoryBinding = DataBindingUtil.inflate(inflater, R.layout.category,
            container, false)
        categoryBinding.categoryViewModel = categoryViewModel
        categoryBinding.lifecycleOwner = this
        observeCategory()
        return (categoryBinding.root)
    }

    fun observeCategory() {
        categoryViewModel.providesCategoryResponse().observe(
            this, {
                when (it) {
                    is NetworkResponseData.Loading -> {

                    }

                    is NetworkResponseData.Success -> {
                        if (it.status.name == "SUCCESS") {

                            Log.d("HASSAAN", it.data!!.toString())
                            cateogaryList = it.data as MutableList<String>
                            setupRecylerView(cateogaryList)
                        }
                    }

                    is NetworkResponseData.Failure -> {
                        if (it.status.name == "EXCEPTION")
                            showToast(it.message ?: StringConstants.genericErrorMessage,
                                context)
                    }
                    is NetworkResponseData.Exception -> {
                        if (it.status.name == "EXCEPTION")
                            showToast(StringConstants.genericErrorMessage, context)
                    }

                }
            }

        )
    }

    fun setupRecylerView(cateogary: List<String>) {
        val categoryAdapter = CategoryAdapter(cateogary,this)
        categoryBinding.catRecyle.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        categoryBinding.catRecyle.adapter = categoryAdapter
    }

    override fun getItemPosition(pos: Int) {
        categroryName= cateogaryList.get(pos).toString()
        showToast(categroryName.toString(),context)

        val action=CategoryFragmentDirections.actionCategoryFragmentToProductFragment(categroryName!!)
        findNavController().navigate(action)

    }

}