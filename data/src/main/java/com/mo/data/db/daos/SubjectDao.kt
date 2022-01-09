package com.mo.data.db.daos

import androidx.room.*
import com.mo.data.db.models.SubjectEntity

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(subjectEntity: SubjectEntity)

    @Query("SELECT * FROM subjectentity")
    suspend fun getSubjects(): List<SubjectEntity>

    @Query("SELECT * FROM subjectentity WHERE name = :subjectName")
    suspend fun getSubject(subjectName: String): SubjectEntity

    @Query("DELETE FROM subjectentity")
    suspend fun deleteAllSubjects()
}