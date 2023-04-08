package com.example.newproject

import androidx.room.*


@Dao
interface PersonalDao {

    @Query("SELECT * FROM Personal ")
    suspend fun getDao():List<Personal>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(person:Personal)
    @Update()
    suspend fun update(person:Personal):Int
    @Delete()
    suspend fun delete(person: Personal):Int

}