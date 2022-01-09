package com.mo.dziennikocen.ui.grades

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.Grade
import com.mo.data.models.State
import com.mo.domain.models.DataStudentToSubject
import com.mo.domain.usecases.db.grade.AddGradeUseCase
import com.mo.domain.usecases.db.student.GetStudentFromDBUseCase
import com.mo.domain.usecases.db.studenttosubject.GetStudentToSubjectFromDBUseCase
import com.mo.dziennikocen.constants.Constants.CORRECT_GRADE_ADD
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddGradeDialogViewModel(
    private val getStudentFromDBUseCase: GetStudentFromDBUseCase,
    private val getStudentToSubjectFromDBUseCase: GetStudentToSubjectFromDBUseCase,
    private val addGradeUseCase: AddGradeUseCase,
    private val studentNumber: String,
    private val subjectName: String
) : ViewModel() {

    val studentName = MutableLiveData(EMPTY_STRING)

    private val _addGradeSuccess = MutableLiveData<String>()
    val addGradeSuccess: LiveData<String>
        get() = _addGradeSuccess

    init {
        getStudentDetails()
    }

    private fun getStudentDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val student = getStudentFromDBUseCase.invoke(studentNumber)
            if (student is State.Success) {
                studentName.postValue(
                    student.data.studentSecondName + " " + student.data.studentName
                )
            }
        }
    }

    fun addGrade(gradeString: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val studentToSubject = getStudentToSubjectFromDBUseCase.invoke(
                DataStudentToSubject(
                    studentNumber,
                    subjectName
                )
            )
            if (studentToSubject is State.Success) {
                val grade = gradeString.toDouble()
                addGradeUseCase.invoke(
                    Grade(
                        studentToSubject.data.studentToSubjectId,
                        grade
                    )
                )
                _addGradeSuccess.postValue(CORRECT_GRADE_ADD)
            }
        }

    }
}