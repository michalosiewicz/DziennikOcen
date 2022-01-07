package com.mo.data.repositories.subject

import com.mo.data.constants.Constants.ADD_SUBJECT_ERROR
import com.mo.data.db.daos.SubjectDao
import com.mo.data.mappers.subject.ListSubjectMapper
import com.mo.data.mappers.subject.SubjectEntityMapper
import com.mo.data.mappers.subject.SubjectMapper
import com.mo.data.models.State
import com.mo.data.models.Subject
import java.lang.Exception

internal class SubjectRepositoryImpl(
    private val subjectDao: SubjectDao,
    private val subjectMapper: SubjectMapper,
    private val listSubjectMapper: ListSubjectMapper,
    private val subjectEntityMapper: SubjectEntityMapper
) : SubjectRepository {

    override suspend fun addSubjectToDB(newSubject: Subject): State<Unit> =
        try {
            subjectDao.insert(subjectMapper.map(newSubject))
            State.Success(Unit)
        } catch (e: Exception) {
            State.Error(ADD_SUBJECT_ERROR)
        }

    override suspend fun getSubjectsFromDB(): State<List<Subject>> =
        State.Success(listSubjectMapper.map(subjectDao.getSubjects()))

    override suspend fun getSubjectFromDB(subjectName: String): State<Subject> =
        State.Success(subjectEntityMapper.map(subjectDao.getSubject(subjectName)))
}