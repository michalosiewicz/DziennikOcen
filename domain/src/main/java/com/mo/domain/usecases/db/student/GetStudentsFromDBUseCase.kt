package com.mo.domain.usecases.db.student

import com.mo.data.models.State
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetStudentsFromDBUseCase : ParameterizedSuspendUseCase<List<String>, List<Student>>

internal class GetStudentsFromDBUseCaseImpl(
    private val studentRepository: StudentRepository
) : GetStudentsFromDBUseCase {

    override suspend fun invoke(input: List<String>): State<List<Student>> {
        val studentsList = mutableListOf<Student>()
        input.forEach { studentNumber ->
            val student = studentRepository.getStudent(studentNumber)
            if (student is State.Success) {
                studentsList.add(student.data)
            }
        }
        return State.Success(studentsList)
    }
}