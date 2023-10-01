package com.example.testnewyork.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface Dao {

    @Transaction
    fun updateCategories(booksCategoryEntity: List<BooksCategoryEntity>) {
        deleteAll()
        insertCategories(booksCategoryEntity)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(booksCategoryEntity: List<BooksCategoryEntity>)

    @Query("SELECT*FROM categories")
    fun getCategories(): List<BooksCategoryEntity>

    @Query("DELETE FROM categories")
    fun deleteAll()
}