package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.ui.adapters.StudentsAdapter
import org.koin.dsl.module

val adaptersModule = module {

    factory {
        StudentsAdapter()
    }
}