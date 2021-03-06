package com.mo.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity(

    @PrimaryKey
    val studentNumber: String,
    val studentName: String,
    val studentSecondName: String
)