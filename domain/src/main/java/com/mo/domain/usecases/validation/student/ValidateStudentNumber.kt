package com.mo.domain.usecases.validation.student

import com.mo.domain.models.State
import com.mo.domain.usecases.ParameterizedUseCase
import com.mo.domain.validation.validators.student.StudentNumberValidator

interface ValidateStudentNumberUseCase : ParameterizedUseCase<String, Boolean>

internal class ValidateStudentNumberUseCaseImpl(
    private val studentNumberValidator: StudentNumberValidator
) : ValidateStudentNumberUseCase {

    override fun invoke(input: String): State<Boolean> {
        val result = studentNumberValidator.validate(input)
        return State.Success(result)
    }
}