package com.mo.data.di.modules

import android.content.Context
import androidx.room.Room
import com.mo.data.db.TeacherAssistantDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single {
        getDB(androidContext())
    }

    single {
        get<TeacherAssistantDataBase>().studentDao()
    }

    single {
        get<TeacherAssistantDataBase>().subjectDao()
    }

    single {
        get<TeacherAssistantDataBase>().studentToSubjectDao()
    }
}

private fun getDB(context: Context) =
    Room.databaseBuilder(
        context.applicationContext,
        TeacherAssistantDataBase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration()
        .build()

const val DATABASE_NAME = "TeacherAssistantDataBase"