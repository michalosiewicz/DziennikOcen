package com.mo.domain.validation.validators

import com.mo.domain.validation.rules.ValidationRule

internal interface Validator<T> {

    fun addRules(listRules: List<ValidationRule<T>>)

    fun validate(value: T): Boolean
}