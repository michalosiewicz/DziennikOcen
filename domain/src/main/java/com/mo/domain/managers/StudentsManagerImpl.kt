package com.mo.domain.managers

import com.mo.data.models.Student

internal class StudentsManagerImpl : StudentsManager {

    override fun removeStudentsFromSubjectInList(
        allStudents: List<Student>,
        studentsNumbersFromSubject: List<String>
    ): List<Student> {

        val result: MutableList<Student> = mutableListOf()
        result.addAll(allStudents)
        allStudents.forEach { student ->
            studentsNumbersFromSubject.forEach { studentNumber ->
                if (student.studentNumber == studentNumber) {
                    result.remove(student)
                }
            }
        }
        return result
    }
}