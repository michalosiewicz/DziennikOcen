package com.mo.domain.usecases.validation.student

import com.mo.data.models.State
import com.mo.domain.usecases.ParameterizedUseCase
import com.mo.domain.validation.validators.student.StudentNameValidator

interface ValidateStudentNameUseCase : ParameterizedUseCase<String, Boolean>

internal class ValidateStudentNameUseCaseImpl(
    private val studentNameValidator: StudentNameValidator
) : ValidateStudentNameUseCase {

    override fun invoke(input: String): State<Boolean> =
        State.Success(studentNameValidator.validate(input))
}