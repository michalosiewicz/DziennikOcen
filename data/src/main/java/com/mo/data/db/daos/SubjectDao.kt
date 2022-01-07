package com.mo.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mo.data.db.models.SubjectEntity

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(subjectEntity: SubjectEntity)

    @Query("SELECT * FROM subjectentity")
    suspend fun getSubjects(): List<SubjectEntity>

    @Query("SELECT * FROM subjectentity WHERE name = :subjectName")
    suspend fun getSubject(subjectName: String): SubjectEntity
}