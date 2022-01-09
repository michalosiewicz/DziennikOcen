package com.mo.domain.validation.rules

internal class TextLengthValidationRule(
    private val range: IntRange
) : ValidationRule<String> {

    override fun check(input: String): Boolean =
        (input.length >= range.first && input.length <= range.last)
}
