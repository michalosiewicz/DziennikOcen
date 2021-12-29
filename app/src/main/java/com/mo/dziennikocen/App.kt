package com.mo.dziennikocen

import android.app.Application
import com.mo.dziennikocen.di.appModules
import com.mo.dziennikocen.domain.di.domainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModules + domainModules)
        }
    }
}