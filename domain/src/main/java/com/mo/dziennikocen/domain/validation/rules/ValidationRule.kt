package com.mo.dziennikocen.domain.validation.rules

internal interface ValidationRule<T> {

    fun check(input: T): Boolean
}