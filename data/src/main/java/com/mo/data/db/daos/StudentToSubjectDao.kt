package com.mo.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mo.data.db.models.StudentToSubjectEntity

@Dao
interface StudentToSubjectDao {

    @Insert
    suspend fun insert(studentToSubjectEntity: StudentToSubjectEntity)

    @Query("SELECT * FROM studenttosubjectentity WHERE subjectName = :subjectName")
    suspend fun getStudentsFromSubject(subjectName: String): List<StudentToSubjectEntity>
}