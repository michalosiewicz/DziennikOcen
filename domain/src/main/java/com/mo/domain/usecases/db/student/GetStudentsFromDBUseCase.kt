package com.mo.domain.usecases.db.student

import com.mo.data.models.Response
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.domain.models.State
import com.mo.domain.usecases.SuspendUseCase

interface GetStudentsFromDBUseCase : SuspendUseCase<List<Student>>

internal class GetStudentsFromDBUseCaseImpl(
    private val studentRepository: StudentRepository
) : GetStudentsFromDBUseCase {

    override suspend fun invoke(): State<List<Student>> =
        when (val result = studentRepository.getStudentsFromDB()) {
            is Response.Success -> State.Success(result.data)
            else -> State.Error("Error")
        }
}