package com.mo.domain.usecases.db.grade

import com.mo.data.models.Grade
import com.mo.data.models.State
import com.mo.data.repositories.grade.GradeRepository
import com.mo.domain.usecases.ParameterizedSuspendUseCase

interface AddGradeUseCase : ParameterizedSuspendUseCase<Grade, Unit>

internal class AddGradeUseCaseImpl(
    private val gradeRepository: GradeRepository
) : AddGradeUseCase {

    override suspend fun invoke(input: Grade): State<Unit> =
        gradeRepository.addGrade(input)
}