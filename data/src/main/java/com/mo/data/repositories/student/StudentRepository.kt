package com.mo.data.repositories.student

import com.mo.data.models.Response
import com.mo.data.models.Student

interface StudentRepository {

    suspend fun addStudentToDB(newStudent: Student): Response<Unit>

    suspend fun getStudentsFromDB(): Response<List<Student>>
}