package com.mo.domain.di.modules

import com.mo.domain.validation.validators.student.StudentNameValidator
import com.mo.domain.validation.validators.student.StudentNumberValidator
import com.mo.domain.validation.validators.student.StudentSecondNameValidator
import com.mo.domain.validation.validators.subject.SubjectNameValidator
import com.mo.domain.validation.validators.subject.SubjectTimesValidator
import org.koin.dsl.module

val validatorModule = module {

    factory {
        SubjectNameValidator()
    }

    factory {
        SubjectTimesValidator()
    }

    factory {
        StudentNameValidator()
    }

    factory {
        StudentSecondNameValidator()
    }

    factory {
        StudentNumberValidator()
    }
}