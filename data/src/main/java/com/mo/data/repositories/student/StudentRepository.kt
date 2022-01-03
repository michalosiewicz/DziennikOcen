package com.mo.data.repositories.student

import com.mo.data.models.State
import com.mo.data.models.Student

interface StudentRepository {

    suspend fun addStudentToDB(newStudent: Student): State<Unit>

    suspend fun getStudentsFromDB(): State<List<Student>>
}