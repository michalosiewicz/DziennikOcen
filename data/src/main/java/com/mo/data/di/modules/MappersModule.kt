package com.mo.data.di.modules

import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.ListStudentMapperImpl
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.mappers.student.StudentMapperImpl
import org.koin.dsl.module

val mappersModule = module {

    single<StudentMapper> {
        StudentMapperImpl()
    }

    single<ListStudentMapper> {
        ListStudentMapperImpl()
    }
}