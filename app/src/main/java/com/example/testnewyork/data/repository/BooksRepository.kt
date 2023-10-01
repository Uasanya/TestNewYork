package com.example.testnewyork.data.repository

import com.example.testnewyork.data.datasource.BooksLocalDataSource
import com.example.testnewyork.data.datasource.BooksRemoteDataSource
import com.example.testnewyork.data.room.BooksCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BooksRepository @Inject constructor(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) {

    suspend fun getBookCategories(): List<BooksCategoryEntity> {
        val categories = listOf("hardcover-fiction", "e-book-fiction", "combined-print-fiction")
        val booksCategories = mutableListOf<BooksCategoryEntity>()
        categories.forEach { category ->
            val response = booksRemoteDataSource.getBooksApi(category)
            booksCategories.add(
                BooksCategoryEntity(
                    listName = response.results.listName,
                    books = response.results.books
                )
            )
        }
        withContext(Dispatchers.IO) {
            booksLocalDataSource.updateBooksCategories(booksCategories)
        }
        return booksCategories
    }

    suspend fun loadBooksCategories() =
        withContext(Dispatchers.IO) { booksLocalDataSource.loadBooks() }
}
