package com.mo.dziennikocen.di

import com.mo.dziennikocen.di.modules.adaptersModule
import com.mo.dziennikocen.di.modules.viewModelsModule

val appModules = listOf(
    viewModelsModule,
    adaptersModule
)