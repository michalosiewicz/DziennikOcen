package com.mo.dziennikocen.domain.di.modules

import com.mo.dziennikocen.domain.validation.validators.subject.SubjectNameValidator
import org.koin.dsl.module

val validatorModule = module {

    factory {
        SubjectNameValidator()
    }
}