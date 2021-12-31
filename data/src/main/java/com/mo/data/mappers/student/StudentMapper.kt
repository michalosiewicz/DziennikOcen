package com.mo.data.mappers.student

import com.mo.data.db.models.StudentEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Student

internal interface StudentMapper: Mapper<Student, StudentEntity>

internal class StudentMapperImpl :StudentMapper {

    override fun map(input: Student): StudentEntity =
        StudentEntity(
            studentName = input.studentName,
            studentSecondName = input.studentSecondName,
            studentNumber = input.studentNumber
        )
}