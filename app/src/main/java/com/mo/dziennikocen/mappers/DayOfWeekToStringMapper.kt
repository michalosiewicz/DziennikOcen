package com.mo.dziennikocen.mappers

import com.mo.data.constants.Constants.UNKNOWN_ERROR
import java.time.DayOfWeek

interface DayOfWeekToStringMapper : Mapper<DayOfWeek, String>

class DayOfWeekToStringMapperImpl : DayOfWeekToStringMapper {

    override fun map(input: DayOfWeek): String =
        when (input) {
            DayOfWeek.MONDAY -> "Poniedziałek"
            DayOfWeek.TUESDAY -> "Wtorek"
            DayOfWeek.WEDNESDAY -> "Środa"
            DayOfWeek.THURSDAY -> "Czwartek"
            DayOfWeek.FRIDAY -> "Piątek"
            DayOfWeek.SATURDAY -> "Sobota"
            DayOfWeek.SUNDAY -> "Niedziela"
            else -> UNKNOWN_ERROR
        }
}