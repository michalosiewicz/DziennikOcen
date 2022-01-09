package com.mo.domain.usecases.db

import com.mo.data.models.State
import com.mo.data.repositories.grade.GradeRepository
import com.mo.data.repositories.student.StudentRepository
import com.mo.data.repositories.studenttosubject.StudentToSubjectRepository
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.domain.usecases.SuspendUseCase

interface DeleteAllRecordsUseCase : SuspendUseCase<Unit>

internal class DeleteAllRecordsUseCaseImpl(
    private val studentRepository: StudentRepository,
    private val subjectRepository: SubjectRepository,
    private val studentToSubjectRepository: StudentToSubjectRepository,
    private val gradeRepository: GradeRepository
) : DeleteAllRecordsUseCase {

    override suspend fun invoke(): State<Unit> {
        studentRepository.deleteAllStudents()
        subjectRepository.deleteAllSubjects()
        studentToSubjectRepository.deleteAllStudentsToSubjects()
        gradeRepository.deleteAllGrades()
        return State.Success(Unit)
    }
}