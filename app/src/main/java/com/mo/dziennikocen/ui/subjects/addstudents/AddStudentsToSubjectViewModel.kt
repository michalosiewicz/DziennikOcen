package com.mo.dziennikocen.ui.subjects.addstudents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.data.models.StudentToSubject
import com.mo.domain.usecases.db.studenttosubject.AddStudentsToSubjectUseCase
import com.mo.domain.usecases.db.studenttosubject.GetStudentsNotInSubjectUseCase
import com.mo.dziennikocen.constants.Constants.CORRECT_STUDENTS_ADD
import com.mo.dziennikocen.ui.adapters.StudentsNotInSubjectAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddStudentsToSubjectViewModel(
    private val getStudentsNotInSubjectUseCase: GetStudentsNotInSubjectUseCase,
    private val addStudentsToSubjectUseCase: AddStudentsToSubjectUseCase,
    val subjectName: String
) : ViewModel() {

    init {
        getStudentsToSubject()
    }

    private lateinit var studentsSelectedList: List<String>

    private val _addStudentSuccess = MutableLiveData<String>()
    val addStudentSuccess: LiveData<String>
        get() = _addStudentSuccess

    val studentsSelected = MutableLiveData<Boolean>()
    val studentsToSubjectAdapter =
        StudentsNotInSubjectAdapter { studentsSelected -> onItemChangeCheckBox(studentsSelected) }


    private fun onItemChangeCheckBox(studentsList: List<String>) {
        studentsSelected.value = studentsList.isNotEmpty()
        studentsSelectedList = studentsList
    }

    private fun getStudentsToSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getStudentsNotInSubjectUseCase.invoke(subjectName)
            if (result is State.Success) {
                studentsToSubjectAdapter.addNewItems(result.data)
            }
        }
    }

    fun addStudentsToSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val studentsToSubjectList = mutableListOf<StudentToSubject>()
            studentsSelectedList.forEach { studentNumber ->
                studentsToSubjectList.add(
                    StudentToSubject(
                        0,
                        studentNumber,
                        subjectName
                    )
                )
            }

            val result = addStudentsToSubjectUseCase.invoke(studentsToSubjectList)
            if (result is State.Success) {
                _addStudentSuccess.postValue(CORRECT_STUDENTS_ADD)
            }
        }
    }
}