package com.mo.data.di.modules

import com.mo.data.mappers.grade.GradeMapper
import com.mo.data.mappers.grade.GradeMapperImpl
import com.mo.data.mappers.grade.ListGradeEntityMapper
import com.mo.data.mappers.grade.ListGradeEntityMapperImpl
import com.mo.data.mappers.student.*
import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.ListStudentMapperImpl
import com.mo.data.mappers.student.StudentEntityMapper
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.mappers.student.StudentMapperImpl
import com.mo.data.mappers.studenttosubject.*
import com.mo.data.mappers.studenttosubject.StudentToSubjectEntityMapper
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapper
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapperImpl
import com.mo.data.mappers.studenttosubject.StudentsToSubjectListMapper
import com.mo.data.mappers.studenttosubject.StudentsToSubjectListMapperImpl
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

    factory<StudentsToSubjectListMapper> {
        StudentsToSubjectListMapperImpl()
    }

    factory<StudentToSubjectMapper> {
        StudentToSubjectMapperImpl()
    }

    factory<StudentEntityMapper> {
        StudentEntityMapperImpl()
    }

    factory<GradeMapper> {
        GradeMapperImpl()
    }

    factory<ListGradeEntityMapper> {
        ListGradeEntityMapperImpl()
    }

    factory<StudentToSubjectEntityMapper> {
        StudentToSubjectEntityMapperImpl()
    }
}