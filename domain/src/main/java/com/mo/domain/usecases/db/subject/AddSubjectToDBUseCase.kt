package com.mo.domain.usecases.db.subject

import com.mo.data.models.State
import com.mo.data.models.Subject
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface AddSubjectToDBUseCase : ParameterizedSuspendUseCase<Subject, Unit>

internal class AddSubjectToDBUseCaseImpl(
    private val subjectRepository: SubjectRepository
) : AddSubjectToDBUseCase {

    override suspend fun invoke(input: Subject): State<Unit> =
        subjectRepository.addSubjectToDB(input)
}