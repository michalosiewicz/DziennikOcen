package com.mo.domain.validation.rules

internal class TextNotBlankValidationRule() : ValidationRule<String> {
    override fun check(input: String): Boolean =
        input.isNotBlank()
}