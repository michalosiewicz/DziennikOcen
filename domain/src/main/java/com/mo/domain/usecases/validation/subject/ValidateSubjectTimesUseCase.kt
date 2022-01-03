package com.mo.domain.usecases.validation.subject

import com.mo.data.models.State
import com.mo.data.models.Times
import com.mo.domain.usecases.ParameterizedUseCase
import com.mo.domain.validation.validators.subject.SubjectTimesValidator

interface ValidateSubjectTimesUseCase : ParameterizedUseCase<Times, Boolean>

internal class ValidateSubjectTimesUseCaseImpl(
    private val subjectTimesValidator: SubjectTimesValidator
) : ValidateSubjectTimesUseCase {

    override fun invoke(input: Times): State<Boolean> =
        State.Success(subjectTimesValidator.validate(input))
}