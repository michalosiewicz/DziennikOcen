package com.mo.domain.usecases.validation.subject

import com.mo.domain.models.State
import com.mo.domain.usecases.ParameterizedUseCase
import com.mo.domain.validation.validators.subject.SubjectNameValidator

interface ValidateSubjectNameUseCase : ParameterizedUseCase<String, Boolean>

internal class ValidateSubjectNameUseCaseImpl(
    private val subjectNameValidator: SubjectNameValidator
) : ValidateSubjectNameUseCase {

    override fun invoke(input: String): State<Boolean> {
        val result = subjectNameValidator.validate(input)
        return State.Success(result)
    }
}