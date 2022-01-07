package com.example.ecommercemvvmpractice2.views.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.adapters.CartAdapter
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.databinding.CartRecyleBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var cartRecyleBinding: CartRecyleBinding
    private val cartViewModel by viewModels<CartViewModel>()

   // private var cartList = List<Cart>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartRecyleBinding =
            DataBindingUtil.inflate(inflater, R.layout.cart_recyle, container, false)

        cartRecyleBinding.cartViewModel = cartViewModel
        cartRecyleBinding.lifecycleOwner = this
        setupViews()
        return (cartRecyleBinding.root)
    }

   fun setupViews(){
       cartViewModel.getDataFromCart().observe(this, Observer {
           setAdapter(it)
       })
   }


    fun setAdapter(cart: List<Cart>) {
        val cartAdapter = CartAdapter(cart)
        cartRecyleBinding.cartRecylerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cartRecyleBinding.cartRecylerview.adapter = cartAdapter
    }


}