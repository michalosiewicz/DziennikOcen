package com.mo.data.repositories.student

import com.mo.data.db.daos.StudentDao
import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.models.Response
import com.mo.data.models.Student

internal class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val studentMapper: StudentMapper,
    private val listStudentMapper: ListStudentMapper
) : StudentRepository {

    override suspend fun addStudentToDB(newStudent: Student): Response<Unit> {
        studentDao.insert(studentMapper.map(newStudent))
        return Response.Success(Unit)
    }

    override suspend fun getStudentsFromDB(): Response<List<Student>> =
        Response.Success(listStudentMapper.map(studentDao.getStudents()))
}