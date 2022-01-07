package com.mo.data.repositories.subject

import com.mo.data.models.State
import com.mo.data.models.Subject

interface SubjectRepository {

    suspend fun addSubjectToDB(newSubject: Subject): State<Unit>

    suspend fun getSubjectsFromDB(): State<List<Subject>>

    suspend fun getSubjectFromDB(subjectName: String): State<Subject>
}