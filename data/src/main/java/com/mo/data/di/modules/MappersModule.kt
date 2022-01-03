package com.mo.data.di.modules

import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.ListStudentMapperImpl
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.mappers.student.StudentMapperImpl
import com.mo.data.mappers.subject.ListSubjectMapper
import com.mo.data.mappers.subject.ListSubjectMapperImpl
import com.mo.data.mappers.subject.SubjectMapper
import com.mo.data.mappers.subject.SubjectMapperImpl
import org.koin.dsl.module

val mappersModule = module {

    factory<StudentMapper> {
        StudentMapperImpl()
    }

    factory<ListStudentMapper> {
        ListStudentMapperImpl()
    }

    factory<SubjectMapper> {
        SubjectMapperImpl()
    }

    factory<ListSubjectMapper> {
        ListSubjectMapperImpl()
    }
}