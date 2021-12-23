package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.ui.students.create.CreateStudentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        CreateStudentViewModel()
    }
}