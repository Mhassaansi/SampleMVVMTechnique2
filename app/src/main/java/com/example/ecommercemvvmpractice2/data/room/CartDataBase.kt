package com.example.ecommercemvvmpractice2.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ecommercemvvmpractice2.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Cart::class], version = 1)

abstract class CartDataBase : RoomDatabase() {

    abstract fun cartDao(): CartDao


    companion object {
        @Volatile
        private var instance: CartDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CartDataBase::class.java, "CartDatabase.db").build()
    }

}