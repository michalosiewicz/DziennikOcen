package com.mo.data.db.daos

import androidx.room.*
import com.mo.data.db.models.StudentEntity

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(studentEntity: StudentEntity)

    @Query("SELECT * FROM studententity")
    suspend fun getStudents(): List<StudentEntity>

    @Query("SELECT * FROM studententity WHERE studentNumber=:studentNumber")
    suspend fun getStudent(studentNumber: String): StudentEntity

    @Query("DELETE FROM studententity")
    suspend fun deleteAllStudents()
}