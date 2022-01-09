package com.mo.data.mappers.grade

import com.mo.data.db.models.GradeEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Grade

internal interface GradeMapper : Mapper<Grade, GradeEntity>

internal class GradeMapperImpl : GradeMapper {

    override fun map(input: Grade): GradeEntity =
        GradeEntity(
            0,
            input.studentToSubjectId,
            input.grade
        )
}