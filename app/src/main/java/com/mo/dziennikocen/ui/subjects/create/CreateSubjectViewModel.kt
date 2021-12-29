package com.mo.dziennikocen.ui.subjects.create

import androidx.lifecycle.*
import com.mo.dziennikocen.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.dziennikocen.extensions.result

class CreateSubjectViewModel(
    private val validateSubjectNameUseCase: ValidateSubjectNameUseCase
) : ViewModel() {

    val subjectName = MutableLiveData("")
    val areInputsCorrect = MediatorLiveData<Boolean>().apply {
        addSource(subjectName) {
            this.value = isSubjectNameCorrect()
        }
    }

    private fun isSubjectNameCorrect() =
        validateSubjectNameUseCase.invoke(subjectName.value ?: "").result()
}