package com.mo.data.di

import com.mo.data.di.modules.dbModule
import com.mo.data.di.modules.mappersModule
import com.mo.data.di.modules.repositoriesModule

val dataModules = listOf(

    dbModule,
    mappersModule,
    repositoriesModule
)