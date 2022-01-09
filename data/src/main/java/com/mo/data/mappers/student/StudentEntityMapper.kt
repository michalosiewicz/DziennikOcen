package com.mo.data.mappers.student

import com.mo.data.db.models.StudentEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Student

internal interface StudentEntityMapper : Mapper<StudentEntity, Student>

internal class StudentEntityMapperImpl : StudentEntityMapper {

    override fun map(input: StudentEntity): Student =
        Student(
            input.studentNumber,
            input.studentName,
            input.studentSecondName
        )
}