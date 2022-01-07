package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentToSubjectEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentNumber: String,
    val subjectName: String
)