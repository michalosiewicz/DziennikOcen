package com.mo.dziennikocen.ui.subjects.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.Grade
import com.mo.data.models.State
import com.mo.data.models.StudentToSubject
import com.mo.domain.models.DataStudentToSubject
import com.mo.domain.usecases.db.grade.GetGradesOfStudentUseCase
import com.mo.domain.usecases.db.student.GetStudentsFromDBUseCase
import com.mo.domain.usecases.db.studenttosubject.GetStudentsToSubjectUseCase
import com.mo.domain.usecases.db.subject.GetSubjectFromDBUseCase
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.mappers.DayOfWeekToStringMapper
import com.mo.dziennikocen.ui.adapters.StudentsToSubjectAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectDetailsViewModel(
    private val getSubjectFromDBUseCase: GetSubjectFromDBUseCase,
    private val getStudentsToSubjectUseCase: GetStudentsToSubjectUseCase,
    private val getStudentsFromDBUseCase: GetStudentsFromDBUseCase,
    private val getGradesOfStudentUseCase: GetGradesOfStudentUseCase,
    private val dayOfWeekToStringMapper: DayOfWeekToStringMapper,
    val subjectName: String
) : ViewModel() {

    val dayOfWeek = MutableLiveData(EMPTY_STRING)
    val timeOfSubject = MutableLiveData(EMPTY_STRING)
    val studentsInSubjectAdapter =
        StudentsToSubjectAdapter({ studentNumber ->
            clickAddGrade(studentNumber)
        },
            { studentNumber -> getGrades(studentNumber) })

    private val _studentToSubjectId = MutableLiveData<DataStudentToSubject>()
    val studentToSubjectId: LiveData<DataStudentToSubject>
        get() = _studentToSubjectId

    private val studentToSubjectList = mutableListOf<StudentToSubject>()
    private val gradesList = mutableListOf<Grade>()

    init {
        getSubject()
        getStudentsOfSubject()
    }

    private fun getSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getSubjectFromDBUseCase.invoke(subjectName)
            if (result is State.Success) {
                dayOfWeek.postValue(
                    dayOfWeekToStringMapper.map(result.data.dayOfWeek)
                )
                val time =
                    result.data.timeStart.toString() + " - " + result.data.timeEnd.toString()
                timeOfSubject.postValue(time)
            }
        }
    }

    private fun getStudentsOfSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getStudentsToSubjectUseCase.invoke(subjectName)
            if (result is State.Success) {
                val studentsNumbers = mutableListOf<String>()
                result.data.forEach { studentToSubject ->
                    studentsNumbers.add(studentToSubject.studentNumber)
                    studentToSubjectList.add(studentToSubject)
                }
                getStudentsGrades(studentToSubjectList)
                val students = getStudentsFromDBUseCase.invoke(studentsNumbers)
                if (students is State.Success) {
                    withContext(Dispatchers.Main) {
                        studentsInSubjectAdapter.addNewItems(students.data)
                    }
                }
            }
        }
    }

    private suspend fun getStudentsGrades(studentToSubjectIdList: List<StudentToSubject>) {
        studentToSubjectIdList.forEach { studentToSubject ->
            val gradesOfStudent =
                getGradesOfStudentUseCase.invoke(studentToSubject.studentToSubjectId)
            if (gradesOfStudent is State.Success) {
                gradesOfStudent.data.forEach { grade ->
                    gradesList.add(grade)
                }
            }
        }
    }

    private fun clickAddGrade(studentNumber: String) {
        _studentToSubjectId.value =
            DataStudentToSubject(
                studentNumber,
                subjectName
            )
        _studentToSubjectId.value = null
    }

    private fun getGrades(studentNumber: String): List<Double> {
        val gradesDouble = mutableListOf<Double>()
        studentToSubjectList.forEach { studentToSubject ->
            if (studentToSubject.studentNumber == studentNumber) {
                gradesList.forEach { grade ->
                    if (grade.studentToSubjectId == studentToSubject.studentToSubjectId) {
                        gradesDouble.add(grade.grade)
                    }
                }
            }
        }
        return gradesDouble
    }
}