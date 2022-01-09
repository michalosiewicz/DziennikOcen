package com.mo.data.repositories.student

import com.mo.data.constants.Constants.ADD_STUDENT_ERROR
import com.mo.data.db.daos.StudentDao
import com.mo.data.mappers.student.ListStudentMapper
import com.mo.data.mappers.student.StudentEntityMapper
import com.mo.data.mappers.student.StudentMapper
import com.mo.data.models.State
import com.mo.data.models.Student
import kotlin.Exception

internal class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val studentMapper: StudentMapper,
    private val listStudentMapper: ListStudentMapper,
    private val studentEntityMapper: StudentEntityMapper
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

    override suspend fun getStudent(studentNumber: String): State<Student> =
        State.Success(studentEntityMapper.map(studentDao.getStudent(studentNumber)))

    override suspend fun deleteAllStudents(): State<Unit> {
        studentDao.deleteAllStudents()
        return State.Success(Unit)
    }
}