package com.mo.domain.usecases.db.studenttosubject

import com.mo.data.models.State
import com.mo.data.models.StudentToSubject
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.domain.models.DataStudentToSubject
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetStudentToSubjectFromDBUseCase :
    ParameterizedSuspendUseCase<DataStudentToSubject, StudentToSubject>

internal class GetStudentToSubjectFromDBUseCaseImpl(
    private val studentToSubjectRepository: StudentToSubjectRepository
) : GetStudentToSubjectFromDBUseCase {

    override suspend fun invoke(input: DataStudentToSubject): State<StudentToSubject> =
        studentToSubjectRepository.getStudentToSubject(input.studentNumber, input.subjectName)
}