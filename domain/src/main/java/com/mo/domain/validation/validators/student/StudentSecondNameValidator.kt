package com.mo.domain.validation.validators.student

import com.mo.domain.validation.rules.TextLengthValidationRule
import com.mo.domain.validation.rules.TextNotBlankValidationRule
import com.mo.domain.validation.validators.BaseValidator

internal class StudentSecondNameValidator : BaseValidator<String>() {

    init {
        addRules(
            listOf(
                TextLengthValidationRule(1..20),
                TextNotBlankValidationRule()
            )
        )
    }
}