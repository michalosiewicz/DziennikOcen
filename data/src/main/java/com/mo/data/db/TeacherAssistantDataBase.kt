package com.mo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mo.data.db.daos.StudentDao
import com.mo.data.db.daos.SubjectDao
import com.mo.data.db.models.StudentEntity
import com.mo.data.db.models.SubjectEntity

@Database(
    entities = [StudentEntity::class, SubjectEntity::class], version = 1
)
abstract class TeacherAssistantDataBase : RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
}