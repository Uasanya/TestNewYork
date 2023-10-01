package com.example.testnewyork.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testnewyork.data.model.Book

@Entity(tableName = "categories")
data class BooksCategoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "list_name")
    val listName: String,
    @ColumnInfo(name = "books")
    val books: List<Book>
)