package com.mo.dziennikocen.ui.students

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.domain.usecases.db.student.GetAllStudentsFromDBUseCase
import com.mo.dziennikocen.ui.adapters.StudentsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentsViewModel(
    private val getAllStudentsFromDBUseCase: GetAllStudentsFromDBUseCase,
    val studentsAdapter: StudentsAdapter
) : ViewModel() {

    init {
        getStudents()
    }

    private fun getStudents() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getAllStudentsFromDBUseCase.invoke()
            if (result is State.Success) {
                studentsAdapter.addNewItems(result.data)
            }
        }
    }
}