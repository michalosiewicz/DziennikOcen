package com.mo.data.mappers.grade

import com.mo.data.db.models.GradeEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Grade

internal interface ListGradeEntityMapper : Mapper<List<GradeEntity>, List<Grade>>

internal class ListGradeEntityMapperImpl : ListGradeEntityMapper {

    override fun map(input: List<GradeEntity>): List<Grade> =
        input.map { gradeEntity ->
            Grade(
                gradeEntity.studentToSubjectId,
                gradeEntity.grade
            )
        }
}