package com.mo.domain.usecases.db.studenttosubject

import com.mo.data.constants.Constants.UNKNOWN_ERROR
import com.mo.data.models.State
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.domain.managers.StudentsManager
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetStudentsNotInSubjectUseCase : ParameterizedSuspendUseCase<String, List<Student>>

internal class GetStudentsNotInSubjectUseCaseImpl(
    private val studentsRepository: StudentRepository,
    private val studentToSubjectRepository: StudentToSubjectRepository,
    private val studentsManager: StudentsManager
) : GetStudentsNotInSubjectUseCase {

    override suspend fun invoke(input: String): State<List<Student>> {
        val allStudents = studentsRepository.getStudentsFromDB()
        val studentsNumberAddedToSubject =
            studentToSubjectRepository.getStudentsToSubject(input)
        return if (allStudents is State.Success && studentsNumberAddedToSubject is State.Success) {
            State.Success(
                studentsManager.removeStudentsFromSubjectInList(
                    allStudents.data,
                    studentsNumberAddedToSubject.data
                )
            )
        } else{
            State.Error(UNKNOWN_ERROR)
        }
    }
}