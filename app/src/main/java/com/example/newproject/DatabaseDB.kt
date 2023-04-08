package com.example.newproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Personal::class],
    version = 1
)
abstract class DatabaseDB : RoomDatabase() {
    abstract fun personalDao(): PersonalDao

    companion object {
        private var INSTANCE: DatabaseDB? = null
        fun getInstance(context: Context): DatabaseDB {
            return INSTANCE ?: Room
                .databaseBuilder(context.applicationContext, DatabaseDB::class.java, "Personal")
                .build().also { INSTANCE = it }

        }
    }
}