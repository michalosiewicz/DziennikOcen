package com.mo.data.repositories.grade

import com.mo.data.models.Grade
import com.mo.data.models.State

interface GradeRepository {

    suspend fun addGrade(grade: Grade): State<Unit>

    suspend fun getGradesStudentInSubject(subjectToSubjectId: Int): State<List<Grade>>

    suspend fun deleteAllGrades():State<Unit>
}