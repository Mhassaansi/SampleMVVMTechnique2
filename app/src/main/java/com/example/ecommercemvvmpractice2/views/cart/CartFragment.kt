package com.example.ecommercemvvmpractice2.views.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.adapters.CartAdapter
import com.example.ecommercemvvmpractice2.data.room.Cart
import com.example.ecommercemvvmpractice2.data.room.CartDataBase
import com.example.ecommercemvvmpractice2.data.room.CartViewModelFactory
import com.example.ecommercemvvmpractice2.databinding.CartRecyleBinding
import com.example.ecommercemvvmpractice2.networking.Repositories.local.CartItemsRepository
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var cartRecyleBinding: CartRecyleBinding
    private lateinit var cartViewModel:CartViewModel

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


        // Initialised View Model
        val cartRepository = CartItemsRepository(CartDataBase(requireContext()))
        val factory = CartViewModelFactory(cartRepository)
        cartViewModel = ViewModelProvider(requireContext(),factory).get(CartViewModel::class.java)
        val cartAdapter = CartAdapter(cart,cartViewModel)
        cartRecyleBinding.cartRecylerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cartRecyleBinding.cartRecylerview.adapter = cartAdapter
       // cartAdapter.notifyDataSetChanged()
    }




}