package com.mo.domain.di.modules

import com.mo.domain.usecases.db.student.AddStudentToDBUseCase
import com.mo.domain.usecases.db.student.AddStudentToDBUseCaseImpl
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
}