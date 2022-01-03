package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek

@Entity
data class SubjectEntity(

    @PrimaryKey
    val name: String,
    val dayOfWeek: DayOfWeek,
    val hourStart: Int,
    val minuteStart: Int,
    val hourEnd: Int,
    val minuteEnd: Int
)