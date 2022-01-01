package com.example.ecommercemvvmpractice2.views.productdescrption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.databinding.ProductDescrptionBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductDescriptionFragment : Fragment() {

    private lateinit var productDescrptionBinding: ProductDescrptionBinding
    private val productDescrptionViewModel by viewModels<ProductDescriptionViewModel>()
    private lateinit var productdescArgs: ProductDescriptionFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productDescrptionBinding =
            DataBindingUtil.inflate(inflater, R.layout.product_descrption, container, false)
        productDescrptionBinding.productDescrptionViewModel = productDescrptionViewModel
        productDescrptionBinding.lifecycleOwner = this
        setupViews()
        return (productDescrptionBinding.root)
    }

    fun setupViews() {
        productDescrptionBinding.productdescriptionName.text =
            productdescArgs.productTitleDescrption
        productDescrptionBinding.productdescriptionDescription.text =
            productdescArgs.productDescDescrption
        productDescrptionBinding.productdescriptionPrice.text =
            productdescArgs.productPriceDescrption
    }

}