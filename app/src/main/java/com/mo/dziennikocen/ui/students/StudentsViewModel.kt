package com.mo.dziennikocen.ui.students

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.domain.models.State
import com.mo.domain.usecases.db.student.GetStudentsFromDBUseCase
import com.mo.dziennikocen.ui.adapters.StudentsAdapter
import kotlinx.coroutines.launch

class StudentsViewModel(
    private val getStudentsFromDBUseCase: GetStudentsFromDBUseCase,
    val studentsAdapter: StudentsAdapter
) : ViewModel() {

    init {
        getStudents()
    }

    private fun getStudents() {
        viewModelScope.launch {
            val result = getStudentsFromDBUseCase.invoke()
            if (result is State.Success) {
                studentsAdapter.addNewItems(result.data)
            }
        }
    }
}