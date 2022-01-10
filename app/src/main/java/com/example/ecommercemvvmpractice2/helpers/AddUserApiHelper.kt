package com.example.ecommercemvvmpractice2.helpers

import com.example.ecommercemvvmpractice2.data.response.NetworkResponseData
import com.example.ecommercemvvmpractice2.networking.Repositories.global.AddUserRepositeory
import com.example.ecommercemvvmpractice2.utilities.constants.NetworkConstants
import kotlinx.coroutines.runBlocking
import om.example.ecommercemvvmpractice2.data.AddUsers
import javax.inject.Inject

class AddUserApiHelper @Inject constructor(private val addUserRepositeory: AddUserRepositeory) {

    suspend fun addUsers(addUsers:AddUsers):NetworkResponseData<AddUsers>{
        return NetworkConstants.performRequest {
            runBlocking {
                addUserRepositeory.addUsers(addUsers)
            }
        }
    }

}