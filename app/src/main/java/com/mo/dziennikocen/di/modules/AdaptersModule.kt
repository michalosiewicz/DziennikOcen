package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.ui.adapters.StudentsAdapter
import com.mo.dziennikocen.ui.adapters.SubjectsAdapter
import com.mo.dziennikocen.ui.subjects.details.SubjectDetailsViewModel
import org.koin.dsl.module

val adaptersModule = module {

    factory {
        StudentsAdapter()
    }
}