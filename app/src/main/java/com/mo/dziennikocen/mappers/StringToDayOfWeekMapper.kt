package com.mo.dziennikocen.mappers

import java.time.DayOfWeek

interface StringToDayOfWeekMapper : Mapper<String, DayOfWeek>

class StringToDayOfWeekMapperImpl : StringToDayOfWeekMapper {

    override fun map(input: String): DayOfWeek =
        when (input) {
            "Poniedziałek" -> DayOfWeek.MONDAY
            "Wtorek" -> DayOfWeek.TUESDAY
            "Środa" -> DayOfWeek.WEDNESDAY
            "Czwartek" -> DayOfWeek.THURSDAY
            "Piątek" -> DayOfWeek.FRIDAY
            "Sobota" -> DayOfWeek.SATURDAY
            "Niedziela" -> DayOfWeek.SUNDAY
            else -> DayOfWeek.MONDAY
        }
}