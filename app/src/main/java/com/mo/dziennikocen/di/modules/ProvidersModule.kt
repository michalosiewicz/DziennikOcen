package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import com.mo.dziennikocen.providers.snackbar.SnackBarProviderImpl
import org.koin.dsl.module

val providersModule = module {

    factory<SnackBarProvider> {
        SnackBarProviderImpl()
    }
}