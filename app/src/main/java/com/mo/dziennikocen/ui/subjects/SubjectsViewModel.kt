package com.mo.dziennikocen.ui.subjects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.domain.usecases.db.subject.GetSubjectsFromDBUseCase
import com.mo.dziennikocen.ui.adapters.SubjectsAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.parameter.parametersOf

class SubjectsViewModel(
    private val getSubjectsFromDBUseCase: GetSubjectsFromDBUseCase
) : ViewModel() {

    init {
        getSubjects()
    }

    val subjectsAdapter = SubjectsAdapter { name -> clickOnSubject(name) }

    private val _subjectDetailsOpen = MutableLiveData<String>()
    val subjectDetailsOpen: LiveData<String>
        get() = _subjectDetailsOpen

    private fun getSubjects() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getSubjectsFromDBUseCase.invoke()
            if (result is State.Success) {
                subjectsAdapter.addNewItems(result.data)
            }
        }
    }

    private fun clickOnSubject(name: String) {
        _subjectDetailsOpen.value = name
        _subjectDetailsOpen.value = null
    }
}