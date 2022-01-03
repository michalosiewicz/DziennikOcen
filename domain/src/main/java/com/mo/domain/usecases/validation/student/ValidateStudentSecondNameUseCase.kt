package com.mo.domain.usecases.validation.student

import com.mo.data.models.State
import com.mo.domain.usecases.ParameterizedUseCase
import com.mo.domain.validation.validators.student.StudentSecondNameValidator

interface ValidateStudentSecondNameUseCase : ParameterizedUseCase<String, Boolean>

internal class ValidateStudentSecondNameUseCaseImpl(
    private val studentSecondNameValidator: StudentSecondNameValidator
) : ValidateStudentSecondNameUseCase {

    override fun invoke(input: String): State<Boolean> =
        State.Success(studentSecondNameValidator.validate(input))
}