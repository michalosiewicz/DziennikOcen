package com.mo.domain.usecases.db.studenttosubject

import com.mo.data.models.State
import com.mo.data.models.StudentToSubject
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetStudentsToSubjectUseCase : ParameterizedSuspendUseCase<String, List<StudentToSubject>>

internal class GetStudentsToSubjectUseCaseImpl(
    private val studentToSubjectRepository: StudentToSubjectRepository,
) : GetStudentsToSubjectUseCase {

    override suspend fun invoke(input: String): State<List<StudentToSubject>> =
        studentToSubjectRepository.getStudentsToSubject(input)
}