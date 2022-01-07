package com.mo.data.mappers.studenttosubject

import com.mo.data.db.models.StudentToSubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.StudentToSubject

internal interface StudentToSubjectMapper : Mapper<StudentToSubject, StudentToSubjectEntity>

internal class StudentToSubjectMapperImpl : StudentToSubjectMapper {

    override fun map(input: StudentToSubject): StudentToSubjectEntity =
        StudentToSubjectEntity(
            input.id,
            input.studentNumber,
            input.subjectName
        )
}