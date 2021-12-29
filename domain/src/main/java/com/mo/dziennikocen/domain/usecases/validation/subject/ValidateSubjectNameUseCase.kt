package com.mo.dziennikocen.domain.usecases.validation.subject

import com.mo.dziennikocen.domain.models.State
import com.mo.dziennikocen.domain.usecases.ParameterizedUseCase
import com.mo.dziennikocen.domain.validation.validators.subject.SubjectNameValidator

interface ValidateSubjectNameUseCase : ParameterizedUseCase<String, Boolean>

internal class ValidateSubjectNameUseCaseImpl(
    private val subjectNameValidator: SubjectNameValidator
) : ValidateSubjectNameUseCase {

    override fun invoke(input: String): State<Boolean> {
        val result = subjectNameValidator.validate(input)
        return State.Success(result)
    }
}