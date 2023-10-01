package com.example.testnewyork.data.datasource

import com.example.testnewyork.data.model.BooksResponse
import com.example.testnewyork.data.network.BooksApi
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor(private val booksApi: BooksApi) {

    suspend fun getBooksApi(category: String): BooksResponse = booksApi.getBooks(category)
}