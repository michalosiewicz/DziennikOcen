package com.mo.data.models

import java.time.DayOfWeek
import java.time.LocalTime

data class Subject(

    val name: String,
    val dayOfWeek: DayOfWeek,
    val timeStart: LocalTime,
    val timeEnd: LocalTime
)