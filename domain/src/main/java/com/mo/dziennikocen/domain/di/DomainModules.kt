package com.mo.dziennikocen.domain.di

import com.mo.dziennikocen.domain.di.modules.useCaseModule
import com.mo.dziennikocen.domain.di.modules.validatorModule

val domainModules = listOf(
    useCaseModule,
    validatorModule
)