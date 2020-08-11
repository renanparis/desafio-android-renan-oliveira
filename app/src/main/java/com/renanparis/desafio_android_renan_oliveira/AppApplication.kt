package com.renanparis.desafio_android_renan_oliveira

import android.app.Application
import com.renanparis.desafio_android_renan_oliveira.di.dataModule
import com.renanparis.desafio_android_renan_oliveira.di.uiModule
import com.renanparis.desafio_android_renan_oliveira.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    uiModule,
                    dataModule,
                    viewModelModule
                )
            )
        }
    }
}
