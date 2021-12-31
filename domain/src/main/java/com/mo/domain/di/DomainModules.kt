package com.mo.domain.di

import com.mo.domain.di.modules.useCaseModule
import com.mo.domain.di.modules.validatorModule

val domainModules = listOf(

    useCaseModule,
    validatorModule
)