package com.mo.dziennikocen.ui.subjects.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.State
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.mappers.DayOfWeekToStringMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectDetailsViewModel(
    private val subjectsRepository: SubjectRepository,
    private val dayOfWeekToStringMapper: DayOfWeekToStringMapper,
    val subjectName: String
) : ViewModel() {

    val dayOfWeek = MutableLiveData(EMPTY_STRING)
    val timeOfSubject = MutableLiveData(EMPTY_STRING)

    init {
        getSubject()
    }

    private fun getSubject() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = subjectsRepository.getSubjectFromDB(subjectName)
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
}