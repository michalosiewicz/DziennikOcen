package com.mo.dziennikocen.ui.subjects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.domain.usecases.db.subject.GetSubjectsFromDBUseCase
import com.mo.dziennikocen.ui.adapters.SubjectsAdapter
import kotlinx.coroutines.launch

class SubjectsViewModel(
    private val getSubjectsFromDBUseCase: GetSubjectsFromDBUseCase,
    val subjectsAdapter: SubjectsAdapter
) : ViewModel() {

    init {
        getSubjects()
    }

    private fun getSubjects() {
        viewModelScope.launch {
            val result = getSubjectsFromDBUseCase.invoke()
            if (result is State.Success) {
                subjectsAdapter.addNewItems(result.data)
            }
        }
    }
}