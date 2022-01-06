package com.example.ecommercemvvmpractice2.views.productdescrption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.databinding.ProductDescrptionBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductDescriptionFragment : Fragment() {

    private lateinit var productDescrptionBinding: ProductDescrptionBinding
    private val productDescrptionViewModels by viewModels<ProductDescriptionViewModel>()
    private val productdescArgs: ProductDescriptionFragmentArgs by navArgs<ProductDescriptionFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productDescrptionBinding =
            DataBindingUtil.inflate(inflater, R.layout.product_descrption, container, false)
        productDescrptionBinding.productDescrptionViewModel = productDescrptionViewModels
        productDescrptionBinding.lifecycleOwner = this
        setupViews()
        return (productDescrptionBinding.root)
    }

    fun setupViews() {
        productDescrptionBinding.imageUrl = productdescArgs.productImageDescrption
        productDescrptionBinding.productdescriptionName.text =
            productdescArgs.productTitleDescrption
        productDescrptionBinding.productdescriptionDescription.text =
            productdescArgs.productDescDescrption
        productDescrptionBinding.productdescriptionPrice.text =
            productdescArgs.productPriceDescrption

        productDescrptionBinding.addToCart.setOnClickListener {

            productDescrptionViewModels.saveCartElement()

        }


        fun saveValueInCart(){
            productDescrptionViewModels.productName

        }

    }

}