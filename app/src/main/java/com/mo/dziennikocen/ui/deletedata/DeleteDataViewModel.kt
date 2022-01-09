package com.mo.dziennikocen.ui.deletedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.domain.usecases.db.DeleteAllRecordsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteDataViewModel(
    private val deleteAllRecordsUseCase: DeleteAllRecordsUseCase
) : ViewModel() {

    fun deleteData() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllRecordsUseCase.invoke()
        }
    }
}