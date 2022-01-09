package com.mo.domain.usecases.db.grade

import com.mo.data.models.Grade
import com.mo.data.models.State
import com.mo.data.repositories.grade.GradeRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface GetGradesOfStudentUseCase : ParameterizedSuspendUseCase<Int, List<Grade>>

internal class GetGradesOfStudentUseCaseImpl(
    private val gradeRepository: GradeRepository
) : GetGradesOfStudentUseCase {

    override suspend fun invoke(input: Int): State<List<Grade>> =
            gradeRepository.getGradesStudentInSubject(input)
}