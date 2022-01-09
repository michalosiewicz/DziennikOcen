package com.mo.data.repositories.grade

import com.mo.data.db.daos.GradeDao
import com.mo.data.mappers.grade.GradeMapper
import com.mo.data.mappers.grade.ListGradeEntityMapper
import com.mo.data.models.Grade
import com.mo.data.models.State

internal class GradeRepositoryImpl(
    private val gradeDao: GradeDao,
    private val gradeMapper: GradeMapper,
    private val listGradeEntityMapper: ListGradeEntityMapper
) : GradeRepository {

    override suspend fun addGrade(grade: Grade): State<Unit> {
        gradeDao.insert(gradeMapper.map(grade))
        return State.Success(Unit)
    }

    override suspend fun getGradesStudentInSubject(subjectToSubjectId: Int): State<List<Grade>> =
        State.Success(
            listGradeEntityMapper.map(
                gradeDao.getGradesFromStudentInSubject(subjectToSubjectId)
            )
        )

    override suspend fun deleteAllGrades(): State<Unit> {
        gradeDao.deleteAllGrades()
        return State.Success(Unit)
    }
}