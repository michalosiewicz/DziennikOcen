package com.mo.domain.validation.validators.subject

import com.mo.domain.validation.rules.TextLengthValidationRule
import com.mo.domain.validation.rules.TextNotBlankValidationRule
import com.mo.domain.validation.validators.BaseValidator

internal class SubjectNameValidator : BaseValidator<String>() {

    init {
        addRules(
            listOf(
                TextLengthValidationRule(1..20),
                TextNotBlankValidationRule()
            )
        )
    }
}