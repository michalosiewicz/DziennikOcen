package com.mo.domain.usecases.db.student

import com.mo.data.models.State
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetStudentFromDBUseCase : ParameterizedSuspendUseCase<String, Student>

internal class GetStudentFromDBUseCaseImpl(
    private val studentRepository: StudentRepository
) : GetStudentFromDBUseCase {

    override suspend fun invoke(input: String): State<Student> =
        studentRepository.getStudent(input)
}