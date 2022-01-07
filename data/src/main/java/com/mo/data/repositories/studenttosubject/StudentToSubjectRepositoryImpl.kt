package com.mo.data.repositories.studenttosubject

import com.mo.data.db.daos.StudentToSubjectDao
import com.mo.data.mappers.studenttosubject.StudentNumberToSubjectMapper
import com.mo.data.mappers.studenttosubject.StudentToSubjectMapper
import com.mo.data.models.State
import com.mo.data.models.StudentToSubject

internal class StudentToSubjectRepositoryImpl(
    private val studentToSubjectDao: StudentToSubjectDao,
    private val studentNumberToSubjectMapper: StudentNumberToSubjectMapper,
    private val studentToSubjectMapper: StudentToSubjectMapper
) : StudentToSubjectRepository {

    override suspend fun addStudentsToSubject(studentsToSubject: List<StudentToSubject>): State<Unit> {
        studentsToSubject.forEach { studentToSubject ->
            studentToSubjectDao.insert(studentToSubjectMapper.map(studentToSubject))
        }
        return State.Success(Unit)
    }

    override suspend fun getStudentsNumbersFromSubject(subjectName: String): State<List<String>> =
        State.Success(
            studentNumberToSubjectMapper.map(
                studentToSubjectDao.getStudentsFromSubject(
                    subjectName
                )
            )
        )
}