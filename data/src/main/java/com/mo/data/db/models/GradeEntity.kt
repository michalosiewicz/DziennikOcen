package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GradeEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentToSubjectId: Int,
    val grade: Double
)