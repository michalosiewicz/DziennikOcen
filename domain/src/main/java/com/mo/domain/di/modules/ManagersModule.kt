package com.mo.domain.di.modules

import com.mo.domain.managers.StudentsManager
import com.mo.domain.managers.StudentsManagerImpl
import org.koin.dsl.module

val managersModule = module {

    factory<StudentsManager> {
        StudentsManagerImpl()
    }
}