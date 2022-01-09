package com.mo.data.repositories.studenttosubject

import com.mo.data.db.daos.StudentToSubjectDao
import com.mo.data.mappers.studenttosubject.StudentToSubjectEntityMapper
import com.mo.data.mappers.studenttosubject.StudentsToSubjectListMapper
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapper
import com.mo.data.models.State
import com.mo.data.models.StudentToSubject

internal class StudentToSubjectRepositoryImpl(
    private val studentToSubjectDao: StudentToSubjectDao,
    private val studentsToSubjectListMapper: StudentsToSubjectListMapper,
    private val studentToSubjectMapper: StudentToSubjectMapper,
    private val studentToSubjectEntityMapper: StudentToSubjectEntityMapper
) : StudentToSubjectRepository {

    override suspend fun addStudentsToSubject(studentsToSubject: List<StudentToSubject>): State<Unit> {
        studentsToSubject.forEach { studentToSubject ->
            studentToSubjectDao.insert(studentToSubjectMapper.map(studentToSubject))
        }
        return State.Success(Unit)
    }

    override suspend fun getStudentsToSubject(subjectName: String): State<List<StudentToSubject>> =
        State.Success(
            studentsToSubjectListMapper.map(
                studentToSubjectDao.getStudentsToSubject(
                    subjectName
                )
            )
        )

    override suspend fun getStudentToSubject(
        studentNumber: String,
        subjectName: String
    ): State<StudentToSubject> =
        State.Success(
            studentToSubjectEntityMapper.map(
                studentToSubjectDao.getStudentToSubject(studentNumber, subjectName)
            )
        )

    override suspend fun deleteAllStudentsToSubjects(): State<Unit> {
        studentToSubjectDao.deleteAllStudentsToSubjects()
        return State.Success(Unit)
    }
}