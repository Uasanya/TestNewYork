package com.example.testnewyork.data.datasource

import com.example.testnewyork.data.room.BooksCategoryEntity
import com.example.testnewyork.data.room.Dao
import javax.inject.Inject

class BooksLocalDataSource @Inject constructor(private val dao: Dao) {

    fun loadBooks() =
        dao.getCategories()

    fun updateBooksCategories(booksCategoryEntity: List<BooksCategoryEntity>) {
        dao.updateCategories(booksCategoryEntity)
    }

}
