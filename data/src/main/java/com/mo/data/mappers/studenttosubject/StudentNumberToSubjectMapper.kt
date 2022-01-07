package com.mo.data.mappers.studenttosubject

import com.mo.data.db.models.StudentToSubjectEntity
import com.mo.data.mappers.Mapper

internal interface StudentNumberToSubjectMapper : Mapper<List<StudentToSubjectEntity>, List<String>>

internal class StudentNumberToSubjectMapperImpl : StudentNumberToSubjectMapper {

    override fun map(input: List<StudentToSubjectEntity>): List<String> =
        input.map { studentToSubjectEntity ->
            studentToSubjectEntity.studentNumber
        }
}