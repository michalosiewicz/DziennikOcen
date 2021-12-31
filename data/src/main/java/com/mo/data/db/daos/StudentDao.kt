package com.mo.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mo.data.db.models.StudentEntity

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(studentEntity: StudentEntity)

    @Query("SELECT * FROM studententity")
    suspend fun getStudents(): List<StudentEntity>
}