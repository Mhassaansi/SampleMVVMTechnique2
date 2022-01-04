package com.example.ecommercemvvmpractice2.views.auth
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercemvvmpractice2.data.request.Auth
import com.example.ecommercemvvmpractice2.data.response.LoginData
import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.helpers.AuthApiHelper
import com.example.ecommercemvvmpractice2.utilities.db.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authApiHelper: AuthApiHelper,
    private val userPrefrences: UserPreferences
) : ViewModel() {

    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
    var isLoading = MutableLiveData(false)

    private var mutableLoginData = MutableLiveData<NetworkResponseData<LoginData>>()

    fun getLogin(): LiveData<NetworkResponseData<LoginData>> {
        return mutableLoginData
    }

    fun login(username: String, password: String) {
        val loginCredentials = Auth(username, password)

        mutableLoginData.postValue(NetworkResponseData.Loading())

        viewModelScope.launch(Dispatchers.IO) {
            mutableLoginData.postValue(authApiHelper.login(loginCredentials))


        }


    }

    fun saveToken(loginResponse: LoginData) {

        viewModelScope.launch(Dispatchers.IO) {
            loginResponse.token?.let { userPrefrences.saveLoginToken(it) }
        }

    }
}