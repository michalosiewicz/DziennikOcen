package com.mo.dziennikocen.ui.subjects.create

import android.view.View
import androidx.lifecycle.*
import com.mo.domain.models.Times
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCase
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.constants.Constants.TIME_START_VALUE
import com.mo.dziennikocen.extensions.changeVisibility
import com.mo.dziennikocen.extensions.result

class CreateSubjectViewModel(
    private val validateSubjectNameUseCase: ValidateSubjectNameUseCase,
    private val validateSubjectTimesUseCase: ValidateSubjectTimesUseCase
) : ViewModel() {

    val subjectName = MutableLiveData(EMPTY_STRING)

    val subjectNameVisibility = MutableLiveData(View.VISIBLE)
    val subjectTimesVisibility = MutableLiveData(View.VISIBLE)

    val hourStart = MutableLiveData(TIME_START_VALUE)
    val minuteStart = MutableLiveData(TIME_START_VALUE)
    val hourEnd = MutableLiveData(TIME_START_VALUE)
    val minuteEnd = MutableLiveData(TIME_START_VALUE)

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
                hourStart.value ?: TIME_START_VALUE,
                minuteStart.value ?: TIME_START_VALUE,
                hourEnd.value ?: TIME_START_VALUE,
                minuteEnd.value ?: TIME_START_VALUE
            )
        ).result()
        subjectTimesVisibility.changeVisibility(result)
        return result
    }

    private fun changeVisibility(visibility: MutableLiveData<Int>, isCorrect: Boolean) {
        if (isCorrect) {
            visibility.value = View.INVISIBLE
        } else {
            visibility.value = View.VISIBLE
        }
    }
}