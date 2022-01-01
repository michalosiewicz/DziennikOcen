package com.mo.data.di.modules

import com.mo.data.repositories.student.StudentRepository
import com.mo.data.repositories.student.StudentRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {

    single<StudentRepository> {
        StudentRepositoryImpl(get(), get(), get())
    }
}