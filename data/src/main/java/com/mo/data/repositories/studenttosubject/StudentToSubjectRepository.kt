package com.mo.data.repositories.studenttosubject

import com.mo.data.models.State
import com.mo.data.models.StudentToSubject

interface StudentToSubjectRepository {

    suspend fun addStudentsToSubject(studentsToSubject: List<StudentToSubject>): State<Unit>

    suspend fun getStudentsNumbersFromSubject(subjectName: String): State<List<String>>
}