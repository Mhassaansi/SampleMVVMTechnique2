package com.example.ecommercemvvmpractice2.utilities.extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide

fun Activity.showToast(message: String, context: Context? = applicationContext, length: Int? = 0){
    Toast.makeText(context, message, length?: 0).show()
}


fun ViewModel.showToast(message: String, context: Context, length: Int? = 0){
    Toast.makeText(context,message,length?: 0)
}

fun Fragment.showToast(message: String, context: Context?, length: Int? = 0){
    Toast.makeText(context, message, length?: 0).show()



}
