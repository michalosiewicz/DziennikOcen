package com.mo.domain.usecases.db.studenttosubject

import com.mo.data.models.State
import com.mo.data.models.StudentToSubject
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface AddStudentsToSubjectUseCase :
    ParameterizedSuspendUseCase<List<StudentToSubject>, Unit>

internal class AddStudentsToSubjectUseCaseImpl(
    private val studentToSubjectRepository: StudentToSubjectRepository
) : AddStudentsToSubjectUseCase {

    override suspend fun invoke(input: List<StudentToSubject>): State<Unit> =
        studentToSubjectRepository.addStudentsToSubject(input)
}