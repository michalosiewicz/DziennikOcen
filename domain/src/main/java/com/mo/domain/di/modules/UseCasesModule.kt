package com.mo.domain.di.modules

import com.mo.domain.usecases.db.DeleteAllRecordsUseCase
import com.mo.domain.usecases.db.DeleteAllRecordsUseCaseImpl
import com.mo.domain.usecases.db.grade.AddGradeUseCase
import com.mo.domain.usecases.db.grade.AddGradeUseCaseImpl
import com.mo.domain.usecases.db.grade.GetGradesOfStudentUseCase
import com.mo.domain.usecases.db.grade.GetGradesOfStudentUseCaseImpl
import com.mo.domain.usecases.db.student.*
import com.mo.domain.usecases.db.student.AddStudentToDBUseCaseImpl
import com.mo.domain.usecases.db.student.GetAllStudentsFromDBUseCaseImpl
import com.mo.domain.usecases.db.studenttosubject.*
import com.mo.domain.usecases.db.studenttosubject.AddStudentsToSubjectUseCaseImpl
import com.mo.domain.usecases.db.studenttosubject.GetStudentsNotInSubjectUseCaseImpl
import com.mo.domain.usecases.db.subject.*
import com.mo.domain.usecases.db.subject.AddSubjectToDBUseCaseImpl
import com.mo.domain.usecases.db.subject.GetSubjectsFromDBUseCaseImpl
import com.mo.domain.usecases.validation.student.*
import com.mo.domain.usecases.validation.student.ValidateStudentNameUseCaseImpl
import com.mo.domain.usecases.validation.student.ValidateStudentSecondNameUseCaseImpl
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectNameUseCaseImpl
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCase
import com.mo.domain.usecases.validation.subject.ValidateSubjectTimesUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<ValidateSubjectNameUseCase> {
        ValidateSubjectNameUseCaseImpl(get())
    }

    single<ValidateSubjectTimesUseCase> {
        ValidateSubjectTimesUseCaseImpl(get())
    }

    single<ValidateStudentNameUseCase> {
        ValidateStudentNameUseCaseImpl(get())
    }

    single<ValidateStudentSecondNameUseCase> {
        ValidateStudentSecondNameUseCaseImpl(get())
    }

    single<ValidateStudentNumberUseCase> {
        ValidateStudentNumberUseCaseImpl(get())
    }

    single<AddStudentToDBUseCase> {
        AddStudentToDBUseCaseImpl(get())
    }

    single<GetAllStudentsFromDBUseCase> {
        GetAllStudentsFromDBUseCaseImpl(get())
    }

    single<AddSubjectToDBUseCase> {
        AddSubjectToDBUseCaseImpl(get())
    }

    single<GetSubjectsFromDBUseCase> {
        GetSubjectsFromDBUseCaseImpl(get())
    }

    single<GetSubjectFromDBUseCase> {
        GetSubjectFromDBUseCaseImpl(get())
    }

    single<GetStudentsNotInSubjectUseCase> {
        GetStudentsNotInSubjectUseCaseImpl(get(), get(), get())
    }

    single<AddStudentsToSubjectUseCase> {
        AddStudentsToSubjectUseCaseImpl(get())
    }

    single<GetStudentsToSubjectUseCase> {
        GetStudentsToSubjectUseCaseImpl(get())
    }

    single<GetStudentsFromDBUseCase> {
        GetStudentsFromDBUseCaseImpl(get())
    }

    single<GetStudentToSubjectFromDBUseCase> {
        GetStudentToSubjectFromDBUseCaseImpl(get())
    }

    single<GetStudentFromDBUseCase> {
        GetStudentFromDBUseCaseImpl(get())
    }

    single<AddGradeUseCase> {
        AddGradeUseCaseImpl(get())
    }

    single<GetGradesOfStudentUseCase> {
        GetGradesOfStudentUseCaseImpl(get())
    }

    single<DeleteAllRecordsUseCase> {
        DeleteAllRecordsUseCaseImpl(get(), get(), get(), get())
    }
}