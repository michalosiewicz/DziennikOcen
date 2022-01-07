package com.mo.domain.di.modules

import com.mo.domain.usecases.db.student.AddStudentToDBUseCase
import com.mo.domain.usecases.db.student.AddStudentToDBUseCaseImpl
import com.mo.domain.usecases.db.student.GetStudentsFromDBUseCase
import com.mo.domain.usecases.db.student.GetStudentsFromDBUseCaseImpl
import com.mo.domain.usecases.db.studenttosubject.GetStudentsToSubjectUseCase
import com.mo.domain.usecases.db.studenttosubject.GetStudentsToSubjectUseCaseImpl
import com.mo.domain.usecases.db.subject.*
import com.mo.domain.usecases.db.subject.AddSubjectToDBUseCaseImpl
import com.mo.domain.usecases.db.subject.GetSubjectsFromDBUseCaseImpl
import com.mo.domain.usecases.validation.student.*
import com.mo.domain.usecases.validation.student.ValidateStudentNameUseCaseImpl
import com.mo.domain.usecases.validation.student.ValidateStudentSecondNameUseCaseImpl
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCaseImpl
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<ValidateSubjectNameUseCase> {
        ValidateSubjectNameUseCaseImpl(get())
    }

    single<ValidateSubjectTimesUseCase> {
        ValidateSubjectTimesUseCaseImpl(get())
    }

    single<ValidateStudentNameUseCase> {
        ValidateStudentNameUseCaseImpl(get())
    }

    single<ValidateStudentSecondNameUseCase> {
        ValidateStudentSecondNameUseCaseImpl(get())
    }

    single<ValidateStudentNumberUseCase> {
        ValidateStudentNumberUseCaseImpl(get())
    }

    single<AddStudentToDBUseCase> {
        AddStudentToDBUseCaseImpl(get())
    }

    single<GetStudentsFromDBUseCase> {
        GetStudentsFromDBUseCaseImpl(get())
    }

    single<AddSubjectToDBUseCase> {
        AddSubjectToDBUseCaseImpl(get())
    }

    single<GetSubjectsFromDBUseCase> {
        GetSubjectsFromDBUseCaseImpl(get())
    }

    single<GetSubjectFromDBUseCase> {
        GetSubjectFromDBUseCaseImpl(get())
    }

    single<GetStudentsToSubjectUseCase> {
        GetStudentsToSubjectUseCaseImpl(get(), get(), get())
    }
}