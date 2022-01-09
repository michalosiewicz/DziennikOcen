package com.mo.domain.managers

import com.mo.data.models.Student
import com.mo.data.models.StudentToSubject

internal interface StudentsManager {

    fun removeStudentsFromSubjectInList(
        allStudents: List<Student>,
        studentsNumbersFromSubject: List<StudentToSubject>
    ): List<Student>
}