package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek

@Entity
data class SubjectEntity(

    @PrimaryKey
    val subjectName: String,
    val dayOfWeek: DayOfWeek
)
