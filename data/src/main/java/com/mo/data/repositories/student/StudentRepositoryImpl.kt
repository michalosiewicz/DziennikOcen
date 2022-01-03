package com.mo.data.repositories.student

import com.mo.data.constants.Constants.ADD_STUDENT_ERROR
import com.mo.data.db.daos.StudentDao
import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.models.State
import com.mo.data.models.Student
import kotlin.Exception

internal class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val studentMapper: StudentMapper,
    private val listStudentMapper: ListStudentMapper
) : StudentRepository {

    override suspend fun addStudentToDB(newStudent: Student): State<Unit> =
        try {
            studentDao.insert(studentMapper.map(newStudent))
            State.Success(Unit)
        } catch (e: Exception) {
            State.Error(ADD_STUDENT_ERROR)
        }

    override suspend fun getStudentsFromDB(): State<List<Student>> =
        State.Success(listStudentMapper.map(studentDao.getStudents()))
}