package com.mo.data.mappers.studenttosubject

import com.mo.data.db.models.StudentToSubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.StudentToSubject

internal interface StudentToSubjectEntityMapper : Mapper<StudentToSubjectEntity, StudentToSubject>

internal class StudentToSubjectEntityMapperImpl : StudentToSubjectEntityMapper {

    override fun map(input: StudentToSubjectEntity): StudentToSubject =
        StudentToSubject(
            input.id,
            input.studentNumber,
            input.subjectName
        )
}