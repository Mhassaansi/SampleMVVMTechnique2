package com.example.ecommercemvvmpractice2.views.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecommercemvvmpractice2.R
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.databinding.LoginActivityBinding
import com.example.ecommercemvvmpractice2.utilities.constants.StringConstants
import com.example.ecommercemvvmpractice2.utilities.db.UserPreferences
import com.example.ecommercemvvmpractice2.utilities.extensions.showToast
import com.example.ecommercemvvmpractice2.views.categories.CategoryFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
//@ExperimentalBadgeUtils
class LoginFragment : Fragment(R.layout.login_activity)
// AppCompatActivity()

{
    @Inject
    lateinit var userPreferences: UserPreferences

    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: LoginActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.login_activity, container, false)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
        }
        observerLoginStatus()
        return (binding.root)
    }


    private fun observerLoginStatus() {

        viewModel.getLogin().observe(this, {
            when (it) {
                is NetworkResponseData.Loading -> {
                    viewModel.isLoading.value = true
                    binding.progressBarLogin.visibility = View.VISIBLE
                }

                is NetworkResponseData.Success -> {
                    // binding.progressBarLogin.visibility=View.INVISIBLE
                    viewModel.isLoading.value = false
                    if (it.status.name == "SUCCESS") {
                        showToast("Success Token Saved", context)
                      ///  viewModel.saveToken(it.data!!.data)
                        val action = LoginFragmentDirections.actionLoginFragmentToCategoryFragment()
                        findNavController().navigate(action)

                    }
                }

                is NetworkResponseData.Failure -> {
                    viewModel.isLoading.value = false
                    showToast(it.message ?: StringConstants.genericErrorMessage, context)
                }
                else -> {
                    viewModel.isLoading.value = false
                    showToast(StringConstants.genericErrorMessage, context)
                }
            }
        })

    }

}

