package com.mo.data.repositories.studenttosubject

import com.mo.data.models.State
import com.mo.data.models.StudentToSubject

interface StudentToSubjectRepository {

    suspend fun addStudentsToSubject(studentsToSubject: List<StudentToSubject>): State<Unit>

    suspend fun getStudentsToSubject(subjectName: String): State<List<StudentToSubject>>

    suspend fun getStudentToSubject(
        studentNumber: String,
        subjectName: String
    ): State<StudentToSubject>

    suspend fun deleteAllStudentsToSubjects(): State<Unit>
}