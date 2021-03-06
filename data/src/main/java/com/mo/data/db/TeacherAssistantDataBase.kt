package com.mo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mo.data.db.daos.GradeDao
import com.mo.data.db.daos.StudentDao
import com.mo.data.db.daos.StudentToSubjectDao
import com.mo.data.db.daos.SubjectDao
import com.mo.data.db.models.GradeEntity
import com.mo.data.db.models.StudentEntity
import com.mo.data.db.models.StudentToSubjectEntity
import com.mo.data.db.models.SubjectEntity

@Database(
    entities = [
        StudentEntity::class,
        SubjectEntity::class,
        StudentToSubjectEntity::class,
        GradeEntity::class
    ],
    version = 4
)
abstract class TeacherAssistantDataBase : RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
    abstract fun studentToSubjectDao(): StudentToSubjectDao
    abstract fun gradeDao(): GradeDao
}