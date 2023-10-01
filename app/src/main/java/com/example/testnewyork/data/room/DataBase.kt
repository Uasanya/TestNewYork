package com.example.testnewyork.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 1,
    entities = [BooksCategoryEntity::class]
)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {

    abstract fun getDao(): Dao
}