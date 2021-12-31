package com.mo.dziennikocen.ui.students.create

import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.data.models.Student
import com.mo.domain.usecases.db.student.AddStudentToDBUseCase
import com.mo.domain.usecases.validation.student.ValidateStudentNameUseCase
import com.mo.domain.usecases.validation.student.ValidateStudentNumberUseCase
import com.mo.domain.usecases.validation.student.ValidateStudentSecondNameUseCase
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.extensions.changeVisibility
import com.mo.dziennikocen.extensions.result
import kotlinx.coroutines.launch

class CreateStudentViewModel(
    private val validateStudentNameUseCase: ValidateStudentNameUseCase,
    private val validateStudentSecondNameUseCase: ValidateStudentSecondNameUseCase,
    private val validateStudentNumberUseCase: ValidateStudentNumberUseCase,
    private val addStudentToDBUseCase: AddStudentToDBUseCase
) : ViewModel() {

    val studentName = MutableLiveData(EMPTY_STRING)
    val studentSecondName = MutableLiveData(EMPTY_STRING)
    val studentNumber = MutableLiveData(EMPTY_STRING)

    val studentNameVisibility = MutableLiveData(View.VISIBLE)
    val studentSecondNameVisibility = MutableLiveData(View.VISIBLE)
    val studentNumberVisibility = MutableLiveData(View.VISIBLE)

    val areInputsCorrect = MediatorLiveData<Boolean>().apply {
        var isNameCorrect = false
        var isSecondNameCorrect = false
        var isNumberCorrect = false
        addSource(studentName) {
            isNameCorrect = isNameCorrect()
            this.value = isNameCorrect && isSecondNameCorrect && isNumberCorrect
        }
        addSource(studentSecondName) {
            isSecondNameCorrect = isSecondNameCorrect()
            this.value = isNameCorrect && isSecondNameCorrect && isNumberCorrect

        }
        addSource(studentNumber) {
            isNumberCorrect = isNumberCorrect()
            this.value = isNameCorrect && isSecondNameCorrect && isNumberCorrect
        }
    }

    private fun isNameCorrect(): Boolean {
        val result = validateStudentNameUseCase.invoke(
            studentName.value ?: EMPTY_STRING
        ).result()
        studentNameVisibility.changeVisibility(result)
        return result
    }

    private fun isSecondNameCorrect(): Boolean {
        val result = validateStudentSecondNameUseCase.invoke(
            studentSecondName.value ?: EMPTY_STRING
        ).result()
        studentSecondNameVisibility.changeVisibility(result)
        return result
    }

    private fun isNumberCorrect(): Boolean {
        val result = validateStudentNumberUseCase.invoke(
            studentNumber.value ?: EMPTY_STRING
        ).result()
        studentNumberVisibility.changeVisibility(result)
        return result
    }

    fun addStudent() {
        val student = Student(
            studentName.value ?: EMPTY_STRING,
            studentSecondName.value ?: EMPTY_STRING,
            studentNumber.value ?: EMPTY_STRING
        )
        viewModelScope.launch {
            addStudentToDBUseCase.invoke(student)
        }
    }
}