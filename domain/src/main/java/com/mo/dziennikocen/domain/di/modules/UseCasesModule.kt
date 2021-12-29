package com.mo.dziennikocen.domain.di.modules

import com.mo.dziennikocen.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.dziennikocen.domain.usecases.validation.subject.ValidateSubjectNameUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<ValidateSubjectNameUseCase> {
        ValidateSubjectNameUseCaseImpl(get())
    }
}