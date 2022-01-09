package com.mo.data.mappers.studenttosubject

import com.mo.data.db.models.StudentToSubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.StudentToSubject

internal interface StudentsToSubjectListMapper :
    Mapper<List<StudentToSubjectEntity>, List<StudentToSubject>>

internal class StudentsToSubjectListMapperImpl : StudentsToSubjectListMapper {

    override fun map(input: List<StudentToSubjectEntity>): List<StudentToSubject> =
        input.map { studentToSubjectEntity ->
            StudentToSubject(
                studentToSubjectEntity.id,
                studentToSubjectEntity.studentNumber,
                studentToSubjectEntity.subjectName
            )
        }
}