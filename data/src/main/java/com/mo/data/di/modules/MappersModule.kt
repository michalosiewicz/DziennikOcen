package com.mo.data.di.modules

import com.mo.data.mappers.student.StudentMapper
import com.mo.data.mappers.student.StudentMapperImpl
import org.koin.dsl.module

val mappersModule = module {

    single<StudentMapper> {
        StudentMapperImpl()
    }
}