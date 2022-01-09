package com.mo.dziennikocen.ui.subjects.create

import android.view.View
import androidx.lifecycle.*
import com.mo.data.models.State
import com.mo.data.models.Subject
import com.mo.data.models.Times
import com.mo.domain.usecases.db.subject.AddSubjectToDBUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCase
import com.mo.dziennikocen.constants.Constants.CORRECT_SUBJECT_ADD
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.constants.Constants.ZERO
import com.mo.dziennikocen.extensions.changeVisibility
import com.mo.dziennikocen.extensions.result
import com.mo.dziennikocen.mappers.StringToDayOfWeekMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalTime

class CreateSubjectViewModel(
    private val validateSubjectNameUseCase: ValidateSubjectNameUseCase,
    private val validateSubjectTimesUseCase: ValidateSubjectTimesUseCase,
    private val addSubjectToDBUseCase: AddSubjectToDBUseCase,
    private val stringToDayOfWeekMapper: StringToDayOfWeekMapper
) : ViewModel() {

    val subjectName = MutableLiveData(EMPTY_STRING)

    val subjectNameVisibility = MutableLiveData(View.VISIBLE)
    val subjectTimesVisibility = MutableLiveData(View.VISIBLE)

    val hourStart = MutableLiveData(ZERO)
    val minuteStart = MutableLiveData(ZERO)
    val hourEnd = MutableLiveData(ZERO)
    val minuteEnd = MutableLiveData(ZERO)

    private val _createSubjectSuccess = MutableLiveData<String>()
    val createSubjectSuccess: LiveData<String>
        get() = _createSubjectSuccess

    private val _createSubjectError = MutableLiveData<String>()
    val createSubjectError: LiveData<String>
        get() = _createSubjectError

    private val listOfTimesLiveData = listOf(
        hourStart,
        minuteStart,
        hourEnd,
        minuteEnd
    )

    val areInputsCorrect = MediatorLiveData<Boolean>().apply {
        var isNameCorrect = false
        var areTimesCorrect = false
        addSource(subjectName) {
            isNameCorrect = isSubjectNameCorrect()
            this.value = isNameCorrect && areTimesCorrect
        }
        listOfTimesLiveData.forEach { liveData ->
            addSource(liveData) {
                areTimesCorrect = areDifferentTimes()
                this.value = isNameCorrect && areTimesCorrect
            }
        }
    }

    private fun isSubjectNameCorrect(): Boolean {
        val result = validateSubjectNameUseCase.invoke(
            subjectName.value ?: EMPTY_STRING
        ).result()
        subjectNameVisibility.changeVisibility(result)
        return result
    }

    private fun areDifferentTimes(): Boolean {
        val result = validateSubjectTimesUseCase.invoke(
            Times(
                LocalTime.of(
                    hourStart.value ?: ZERO,
                    minuteStart.value ?: ZERO,
                ),
                LocalTime.of(
                    hourEnd.value ?: ZERO,
                    minuteEnd.value ?: ZERO,
                )
            )
        ).result()
        subjectTimesVisibility.changeVisibility(result)
        return result
    }

    fun addSubject(dayOfWeek: String) {
        val subject = Subject(
            subjectName.value?.trim() ?: EMPTY_STRING,
            stringToDayOfWeekMapper.map(dayOfWeek),
            LocalTime.of(
                hourStart.value ?: ZERO,
                minuteStart.value ?: ZERO,
            ),
            LocalTime.of(
                hourEnd.value ?: ZERO,
                minuteEnd.value ?: ZERO,
            )
        )
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = addSubjectToDBUseCase.invoke(subject)) {
                is State.Success -> _createSubjectSuccess.postValue(CORRECT_SUBJECT_ADD)
                is State.Error -> _createSubjectError.postValue(response.message)
                else -> _createSubjectError.postValue(com.mo.data.constants.Constants.UNKNOWN_ERROR)
            }
        }
    }
}