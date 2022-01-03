package com.mo.data.mappers.subject

import com.mo.data.db.models.SubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Subject

internal interface SubjectMapper : Mapper<Subject, SubjectEntity>

internal class SubjectMapperImpl : SubjectMapper {

    override fun map(input: Subject): SubjectEntity =
        SubjectEntity(
            input.name,
            input.dayOfWeek,
            input.timeStart.hour,
            input.timeStart.minute,
            input.timeEnd.hour,
            input.timeEnd.minute,
        )
}