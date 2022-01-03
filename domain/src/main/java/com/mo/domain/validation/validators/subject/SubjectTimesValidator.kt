package com.mo.domain.validation.validators.subject

import com.mo.data.models.Times
import com.mo.domain.validation.rules.DifferentTimesValidationRule
import com.mo.domain.validation.validators.BaseValidator

internal class SubjectTimesValidator : BaseValidator<Times>() {

    init {
        addRules(
            listOf(
                DifferentTimesValidationRule()
            )
        )
    }
}