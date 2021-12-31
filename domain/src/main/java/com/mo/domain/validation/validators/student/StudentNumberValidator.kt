package com.mo.domain.validation.validators.student

import com.mo.domain.validation.rules.StudentNumberValidationRule
import com.mo.domain.validation.validators.BaseValidator

internal class StudentNumberValidator : BaseValidator<String>() {

    init {
        addRules(
            listOf(
                StudentNumberValidationRule()
            )
        )
    }
}