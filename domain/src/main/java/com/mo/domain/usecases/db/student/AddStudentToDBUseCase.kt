package com.mo.domain.usecases.db.student

import com.mo.data.models.State
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface AddStudentToDBUseCase : ParameterizedSuspendUseCase<Student, Unit>

internal class AddStudentToDBUseCaseImpl(
    private val studentRepository: StudentRepository
) : AddStudentToDBUseCase {

    override suspend fun invoke(input: Student): State<Unit> =
        studentRepository.addStudentToDB(input)
}