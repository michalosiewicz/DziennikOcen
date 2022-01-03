package com.mo.domain.usecases.db.student

import com.mo.data.models.State
import com.mo.data.models.Student
import com.mo.data.repositories.student.StudentRepository
import com.mo.domain.usecases.SuspendUseCase

interface GetStudentsFromDBUseCase : SuspendUseCase<List<Student>>

internal class GetStudentsFromDBUseCaseImpl(
    private val studentRepository: StudentRepository
) : GetStudentsFromDBUseCase {

    override suspend fun invoke(): State<List<Student>> =
        studentRepository.getStudentsFromDB()
}