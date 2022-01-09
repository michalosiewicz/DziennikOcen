package com.mo.data.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mo.data.db.models.GradeEntity

@Dao
interface GradeDao {

    @Insert
    suspend fun insert(gradeEntity: GradeEntity)

    @Query("SELECT * FROM gradeentity WHERE studentToSubjectId=:studentToSubjectId")
    suspend fun getGradesFromStudentInSubject(studentToSubjectId: Int): List<GradeEntity>

    @Query("DELETE FROM gradeentity")
    suspend fun deleteAllGrades()
}