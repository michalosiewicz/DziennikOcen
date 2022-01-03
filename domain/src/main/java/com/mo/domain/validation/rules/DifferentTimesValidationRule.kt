package com.mo.domain.validation.rules

import com.mo.data.models.Times

internal class DifferentTimesValidationRule : ValidationRule<Times> {

    override fun check(input: Times): Boolean =
        input.timeStart != input.timeEnd
}