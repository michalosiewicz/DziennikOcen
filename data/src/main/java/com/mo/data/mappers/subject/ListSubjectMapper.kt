package com.mo.data.mappers.subject

import com.mo.data.db.models.SubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Subject
import java.time.LocalTime

internal interface ListSubjectMapper : Mapper<List<SubjectEntity>, List<Subject>>

internal class ListSubjectMapperImpl : ListSubjectMapper {

    override fun map(input: List<SubjectEntity>): List<Subject> =
        input.map { subjectEntity ->
            Subject(
                subjectEntity.name,
                subjectEntity.dayOfWeek,
                LocalTime.of(
                    subjectEntity.hourStart,
                    subjectEntity.minuteStart
                ),
                LocalTime.of(
                    subjectEntity.hourEnd,
                    subjectEntity.minuteEnd
                )
            )
        }
}