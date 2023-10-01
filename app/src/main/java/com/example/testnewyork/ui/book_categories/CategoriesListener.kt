package com.example.testnewyork.ui.book_categories

import com.example.testnewyork.data.model.Book

interface CategoriesListener {

    fun navigateToBooksList(books: List<Book>)
}