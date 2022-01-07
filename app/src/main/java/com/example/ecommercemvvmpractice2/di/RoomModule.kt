package com.example.ecommercemvvmpractice2.di

import android.app.Application
import androidx.room.Room
import com.example.ecommercemvvmpractice2.data.room.CartDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


//@Module
//@InstallIn(ApplicationScope::class)
object RoomModule {

//    @Provides
//    @Singleton
//    fun provideDatabse(
//        app: Application,
//        callBack: CartDataBase.CallBack
//    ) = Room.databaseBuilder(app, CartDataBase::class.java, "cart_database")
//        .fallbackToDestructiveMigration()
//        .addCallback(callBack)
//        .build()
//
//
//    @Provides
//    fun provideCartDao(db: CartDataBase) = db.cartDao()
//
//    @ApplicationScope
//    @Provides
//    @Singleton
//    fun providesApplicaionScope() = CoroutineScope(SupervisorJob())


}

//@Retention(AnnotationRetention.RUNTIME)
//@Qualifier
//annotation class ApplicationScope