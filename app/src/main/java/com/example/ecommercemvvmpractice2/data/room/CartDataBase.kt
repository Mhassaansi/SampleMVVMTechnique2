package com.example.ecommercemvvmpractice2.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ecommercemvvmpractice2.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Cart::class], version = 1)

abstract class CartDataBase : RoomDatabase() {

    abstract fun cartDao(): CartDao


    class CallBack @Inject constructor(
        private val database: Provider<CartDataBase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().cartDao()
        }
    }

}