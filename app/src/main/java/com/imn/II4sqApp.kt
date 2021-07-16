package com.imn

import android.app.Application
import com.imn.ii4sq.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class II4sqApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@II4sqApp)
            modules(appModule)
        }
    }
}