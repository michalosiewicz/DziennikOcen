package com.mo.domain.managers

import com.mo.data.models.Student
import com.mo.data.models.StudentToSubject

internal class StudentsManagerImpl : StudentsManager {

    override fun removeStudentsFromSubjectInList(
        allStudents: List<Student>,
        studentsNumbersFromSubject: List<StudentToSubject>
    ): List<Student> {

        val result: MutableList<Student> = mutableListOf()
        result.addAll(allStudents)
        allStudents.forEach { student ->
            studentsNumbersFromSubject.forEach { studentToSubject ->
                if (student.studentNumber == studentToSubject.studentNumber) {
                    result.remove(student)
                }
            }
        }
        return result
    }
}