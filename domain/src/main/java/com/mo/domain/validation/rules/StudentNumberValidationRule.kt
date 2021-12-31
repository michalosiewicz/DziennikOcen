package com.mo.domain.validation.rules

internal class StudentNumberValidationRule : ValidationRule<String> {

    override fun check(input: String): Boolean {
        val pattern = Regex("[0-9]{6}")
        return pattern.matches(input)
    }
}