package com.mo.domain.managers

import com.mo.data.models.Student

internal interface StudentsManager {

    fun removeStudentsFromSubjectInList(
        allStudents: List<Student>,
        studentsNumbersFromSubject: List<String>
    ): List<Student>
}