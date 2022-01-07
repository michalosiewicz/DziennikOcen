package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.ui.students.StudentsViewModel
import com.mo.dziennikocen.ui.students.create.CreateStudentViewModel
import com.mo.dziennikocen.ui.subjects.SubjectsViewModel
import com.mo.dziennikocen.ui.subjects.addstudents.AddStudentsToSubjectViewModel
import com.mo.dziennikocen.ui.subjects.create.CreateSubjectViewModel
import com.mo.dziennikocen.ui.subjects.details.SubjectDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        CreateStudentViewModel(get(), get(), get(), get())
    }

    viewModel {
        CreateSubjectViewModel(get(), get(), get(), get())
    }

    viewModel {
        StudentsViewModel(get(), get())
    }

    viewModel {
        SubjectsViewModel(get())
    }

    viewModel { parameters ->
        SubjectDetailsViewModel(get(), get(), subjectName = parameters[0])
    }

    viewModel { parameters ->
        AddStudentsToSubjectViewModel(get(), subjectName = parameters[0])
    }
}