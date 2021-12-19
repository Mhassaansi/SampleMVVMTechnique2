package com.example.ecommercemvvmpractice2.utilities.constants

import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.utilities.enums.RequestStatus
import com.example.ecommercemvvmpractice2.utilities.extensions.handleExceptionForRequests
import okhttp3.Credentials
import java.lang.Exception

object NetworkConstants {

    const val requestTimeoutInSeconds: Long = 120

    const val baseUrl="https://fakestoreapi.com/"

    fun <T> performRequest(apiMethodToCall: () -> T): NetworkResponseData<T> {
        var result: NetworkResponseData<T>
        try {
            val res = apiMethodToCall()
            if(res == null){
                result = NetworkResponseData.Failure(RequestStatus.ERROR,"error")
            }else{
                result = NetworkResponseData.Success(RequestStatus.SUCCESS,res)
            }
        }
        catch (ex: Exception) {
            result = ex.handleExceptionForRequests()
        }
        return result
    }

}