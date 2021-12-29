package com.mo.dziennikocen.ui.subjects.create

import android.view.View
import androidx.lifecycle.*
import com.mo.dziennikocen.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.dziennikocen.extensions.result

class CreateSubjectViewModel(
    private val validateSubjectNameUseCase: ValidateSubjectNameUseCase
) : ViewModel() {

    val subjectName = MutableLiveData("")
    val subjectNameVisibility = MutableLiveData(View.VISIBLE)
    val areInputsCorrect = MediatorLiveData<Boolean>().apply {
        addSource(subjectName) {
            this.value = isSubjectNameCorrect()
            changeVisibilityOfSubjectInfo()
        }
    }

    private fun isSubjectNameCorrect() =
        validateSubjectNameUseCase.invoke(subjectName.value ?: "").result()

    private fun changeVisibilityOfSubjectInfo() {
        areInputsCorrect.value?.let {
            if (it) {
                subjectNameVisibility.value = View.INVISIBLE
            } else {
                subjectNameVisibility.value = View.VISIBLE
            }
        }
    }
}