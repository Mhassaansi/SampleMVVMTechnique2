package com.example.ecommercemvvmpractice2.views.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.databinding.LoginActivityBinding
import com.example.ecommercemvvmpractice2.utilities.constants.StringConstants
import com.example.ecommercemvvmpractice2.utilities.db.UserPreferences
import com.example.ecommercemvvmpractice2.utilities.extensions.showToast
import com.google.android.material.badge.ExperimentalBadgeUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
//@ExperimentalBadgeUtils
class LoginFragment : AppCompatActivity()
  //  Fragment(R.layout.login_activity)
{
    @Inject
    lateinit var userPreferences: UserPreferences

    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()
    private lateinit var loginActivityBinding: LoginActivityBinding

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//       val binding=LoginActivityBinding.bind(view)
//        binding.lifecycleOwner=this
//      //  binding.loginViewModel=viewModel
//        observerLoginStatus()
//
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginActivityBinding = DataBindingUtil.setContentView(this,R.layout.login_activity)
        loginActivityBinding.lifecycleOwner = this
        loginActivityBinding.loginViewModel = viewModel
        observerLoginStatus()



    }
    private fun observerLoginStatus() {

        viewModel.getLogin().observe(this, {
            when (it) {

                is NetworkResponseData.Loading -> {
                    viewModel.isLoading.value = true
                    loginActivityBinding.progressBarLogin.visibility = View.VISIBLE

                }

                is NetworkResponseData.Success -> {
                    viewModel.isLoading.value = false
                    if (it.data!!.status == 200) {
                        viewModel.saveToken(it.data)

                    }
                }

                is NetworkResponseData.Failure -> {
                    viewModel.isLoading.value = false
                    showToast(it.message ?: StringConstants.genericErrorMessage, this)
                }
                else -> {
                    viewModel.isLoading.value = false
                    showToast(StringConstants.genericErrorMessage, this)
                }
            }
        })

    }

}

