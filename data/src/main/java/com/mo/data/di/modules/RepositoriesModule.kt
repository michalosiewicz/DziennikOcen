package com.mo.data.di.modules

import com.mo.data.repositories.student.StudentRepository
import com.mo.data.repositories.student.StudentRepositoryImpl
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepositoryImpl
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.data.repositories.subject.SubjectRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {

    factory<StudentRepository> {
        StudentRepositoryImpl(get(), get(), get())
    }

    factory<SubjectRepository> {
        SubjectRepositoryImpl(get(), get(), get(), get())
    }

    factory<StudentToSubjectRepository> {
        StudentToSubjectRepositoryImpl(get(), get(), get())
    }
}