package com.mo.data.repositories.student

import com.mo.data.db.daos.StudentDao
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.models.Student

internal class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val studentMapper: StudentMapper
) : StudentRepository {

    override suspend fun addStudentToDB(newStudent: Student) {
        studentDao.insert(studentMapper.map(newStudent))
    }
}