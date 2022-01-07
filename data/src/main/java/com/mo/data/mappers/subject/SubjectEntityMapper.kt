package com.mo.data.mappers.subject

import com.mo.data.db.models.SubjectEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Subject
import java.time.LocalTime

internal interface SubjectEntityMapper : Mapper<SubjectEntity, Subject>

internal class SubjectEntityMapperImpl : SubjectEntityMapper {

    override fun map(input: SubjectEntity): Subject =
        Subject(
            input.name,
            input.dayOfWeek,
            LocalTime.of(
                input.hourStart,
                input.minuteStart
            ),
            LocalTime.of(
                input.hourEnd,
                input.minuteEnd
            )
        )

}