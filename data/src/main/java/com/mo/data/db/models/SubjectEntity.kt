package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

@Entity
data class SubjectEntity(

    @PrimaryKey(autoGenerate = true)
    val subjectName: String,
    val dayOfWeek: DayOfWeek,
    val timeStart: LocalTime,
    val timeEnd: LocalTime
)