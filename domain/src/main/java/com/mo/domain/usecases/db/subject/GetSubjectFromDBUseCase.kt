package com.mo.domain.usecases.db.subject

import com.mo.data.models.State
import com.mo.data.models.Subject
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetSubjectFromDBUseCase : ParameterizedSuspendUseCase<String, Subject>

internal class GetSubjectFromDBUseCaseImpl(
    private val subjectRepository: SubjectRepository
) : GetSubjectFromDBUseCase {

    override suspend fun invoke(input: String): State<Subject> =
        subjectRepository.getSubjectFromDB(input)
}