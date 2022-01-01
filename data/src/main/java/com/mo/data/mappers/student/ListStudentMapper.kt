package com.mo.data.mappers.student

import com.mo.data.db.models.StudentEntity
import com.mo.data.mappers.Mapper
import com.mo.data.models.Student

internal interface ListStudentMapper : Mapper<List<StudentEntity>, List<Student>>

internal class ListStudentMapperImpl : ListStudentMapper {

    override fun map(input: List<StudentEntity>): List<Student> =
        input.map { studentEntity ->
            Student(
                studentEntity.studentNumber,
                studentEntity.studentName,
                studentEntity.studentSecondName
            )
        }
}