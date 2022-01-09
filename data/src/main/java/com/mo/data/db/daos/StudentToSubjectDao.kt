package com.mo.data.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mo.data.db.models.StudentToSubjectEntity

@Dao
interface StudentToSubjectDao {

    @Insert
    suspend fun insert(studentToSubjectEntity: StudentToSubjectEntity)

    @Query("SELECT * FROM studenttosubjectentity WHERE subjectName = :subjectName")
    suspend fun getStudentsToSubject(subjectName: String): List<StudentToSubjectEntity>

    @Query("SELECT * FROM studenttosubjectentity WHERE (subjectName = :subjectName AND studentNumber=:studentNumber)")
    suspend fun getStudentToSubject(
        studentNumber: String,
        subjectName: String
    ): StudentToSubjectEntity

    @Query("DELETE FROM studenttosubjectentity")
    suspend fun deleteAllStudentsToSubjects()
}