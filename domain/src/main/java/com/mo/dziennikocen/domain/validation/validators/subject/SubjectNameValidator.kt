package com.mo.dziennikocen.domain.validation.validators.subject

import com.mo.dziennikocen.domain.validation.rules.TextLengthValidationRule
import com.mo.dziennikocen.domain.validation.validators.BaseValidator

internal class SubjectNameValidator : BaseValidator<String>() {

    init {
        addRules(
            listOf(
                TextLengthValidationRule(2..20)
            )
        )
    }
}