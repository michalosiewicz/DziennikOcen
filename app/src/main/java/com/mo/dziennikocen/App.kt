package com.mo.dziennikocen

import android.app.Application
import com.mo.data.di.dataModules
import com.mo.domain.di.domainModules
import com.mo.dziennikocen.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModules + domainModules + dataModules)
        }
    }
}