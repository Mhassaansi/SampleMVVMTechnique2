package com.example.ecommercemvvmpractice2.views.product

import android.os.Bundle
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
import com.example.ecommercemvvmpractice2.data.response.ProductResponse
import com.example.ecommercemvvmpractice2.databinding.ProductRecycleBinding
import com.example.ecommercemvvmpractice2.interfaces.itemClickListener
import com.example.ecommercemvvmpractice2.adapters.ProductAdapter
import com.example.ecommercemvvmpractice2.utilities.constants.StringConstants
import com.example.ecommercemvvmpractice2.utilities.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductFragment : Fragment(), itemClickListener {

    private val productViewModel by viewModels<ProductViewModel>()
    private lateinit var productRecycleBinding: ProductRecycleBinding
    private val productFragmentArgs: ProductFragmentArgs by navArgs<ProductFragmentArgs>()
    private lateinit var productList: MutableList<ProductResponse>

    private var catName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productRecycleBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.product_recycle, container, false
        )

        productRecycleBinding.prodViewModel = productViewModel
        productRecycleBinding.lifecycleOwner = this

        getProducts()

        return (productRecycleBinding.root)
    }


    fun getProducts() {
        catName = productFragmentArgs.categoryName.toString()

        productViewModel.getProductData(catName!!).observe(this, {
            when (it) {
                is NetworkResponseData.Loading -> {
                    productViewModel.isLoading.value = true
                    productRecycleBinding.productProgress.visibility = View.VISIBLE
                }
                is NetworkResponseData.Success -> {
                    productViewModel.isLoading.value=false
                    if (it.status.name == "SUCCESS") {

                        // val productList: MutableList<ProductResponse> =
                        productList = it.data as MutableList<ProductResponse>
                        setupProductAdapter(productList)
                    }
                }

                is NetworkResponseData.Failure -> {
                    if (it.status.name == "ERROR")
                        showToast(
                            it.message ?: StringConstants.genericErrorMessage,
                            context
                        )
                }
                is NetworkResponseData.Exception -> {
                    if (it.status.name == "EXCEPTION")
                        showToast(StringConstants.genericErrorMessage, context)
                }
            }
        })


    }

    fun setupProductAdapter(product: List<ProductResponse>) {
        val productAdapter = ProductAdapter(product, this)
        productRecycleBinding.prodRecyle.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        productRecycleBinding.prodRecyle.adapter = productAdapter

    }

    override fun getItemPosition(pos: Int) {

        val action = ProductFragmentDirections.actionProductFragmentToProductDescriptionFragment2(
            productList.get(pos).image.toString(), productList.get(pos).title.toString(),
            productList.get(pos).description.toString(), productList.get(pos).price.toString(),
            productList.get(pos).category.toString(),productList.get(pos).id!!.toInt()
        )
        findNavController().navigate(action)

    }
}