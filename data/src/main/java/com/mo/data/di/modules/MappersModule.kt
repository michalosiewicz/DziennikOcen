package com.mo.data.di.modules

import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.ListStudentMapperImpl
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.mappers.student.StudentMapperImpl
import com.mo.data.mappers.studenttosubject.StudentNumberToSubjectMapper
import com.mo.data.mappers.studenttosubject.StudentNumberToSubjectMapperImpl
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapper
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapperImpl
import com.mo.data.mappers.subject.*
import com.mo.data.mappers.subject.ListSubjectMapper
import com.mo.data.mappers.subject.ListSubjectMapperImpl
import com.mo.data.mappers.subject.SubjectEntityMapper
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

    factory<SubjectEntityMapper> {
        SubjectEntityMapperImpl()
    }

    factory<StudentNumberToSubjectMapper> {
        StudentNumberToSubjectMapperImpl()
    }

    factory<StudentToSubjectMapper> {
        StudentToSubjectMapperImpl()
    }
}