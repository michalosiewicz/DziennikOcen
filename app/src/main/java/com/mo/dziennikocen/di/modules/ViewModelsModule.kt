package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.ui.deletedata.DeleteDataViewModel
import com.mo.dziennikocen.ui.grades.AddGradeDialogViewModel
import com.mo.dziennikocen.ui.menu.MenuViewModel
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
        SubjectDetailsViewModel(get(), get(), get(), get(), get(), subjectName = parameters[0])
    }

    viewModel { parameters ->
        AddStudentsToSubjectViewModel(get(), get(), subjectName = parameters[0])
    }

    viewModel { parameters ->
        AddGradeDialogViewModel(
            get(),
            get(),
            get(),
            studentNumber = parameters[0],
            subjectName = parameters[1]
        )
    }

    viewModel {
        MenuViewModel()
    }

    viewModel {
        DeleteDataViewModel(get())
    }
}