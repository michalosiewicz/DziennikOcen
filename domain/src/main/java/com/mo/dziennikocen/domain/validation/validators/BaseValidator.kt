package com.mo.dziennikocen.domain.validation.validators

import com.mo.dziennikocen.domain.validation.rules.ValidationRule

internal abstract class BaseValidator<T> : Validator<T> {

    private val rules = mutableListOf<ValidationRule<T>>()

    override fun addRules(listRules: List<ValidationRule<T>>) {
        listRules.forEach { rule ->
            rules.add(rule)
        }
    }

    override fun validate(value: T): Boolean {
        rules.forEach { rule ->
            if (!rule.check(value)) {
                return false
            }
        }
        return true
    }
}