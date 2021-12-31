package com.mo.domain.validation.rules

import com.mo.domain.models.Times

internal class DifferentTimesValidationRule : ValidationRule<Times> {

    override fun check(input: Times): Boolean =
        input.hourStart != input.hourEnd || input.minuteStart != input.minuteEnd
}