package com.mo.dziennikocen.ui.subjects.addstudents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.domain.usecases.db.studenttosubject.GetStudentsToSubjectUseCase
import com.mo.dziennikocen.ui.adapters.StudentsToSubjectAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddStudentsToSubjectViewModel(
    private val getStudentsToSubjectUseCase: GetStudentsToSubjectUseCase,
    val subjectName: String
) : ViewModel() {

    val studentsSelected = MutableLiveData<Boolean>()
    val studentsToSubjectAdapter =
        StudentsToSubjectAdapter { studentsSelected -> onItemChangeCheckBox(studentsSelected) }

    init {
        getStudentsToSubject()
    }

    private fun onItemChangeCheckBox(studentsList: List<String>) {
        studentsSelected.value = studentsList.isNotEmpty()
    }

    private fun getStudentsToSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getStudentsToSubjectUseCase.invoke(subjectName)
            if (result is State.Success) {
                studentsToSubjectAdapter.addNewItems(result.data)
            }
        }
    }

    fun addStudentsToSubject(){

    }
}