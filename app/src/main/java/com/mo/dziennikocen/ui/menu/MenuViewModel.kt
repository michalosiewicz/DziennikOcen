package com.mo.dziennikocen.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mo.domain.usecases.db.DeleteAllRecordsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel() : ViewModel()