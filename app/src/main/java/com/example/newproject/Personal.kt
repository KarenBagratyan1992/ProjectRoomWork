package com.example.newproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val idEmpemando:Long?,
    val email:String?,
    @ColumnInfo("gazan")
    val password: String?
)