package com.example.testnewyork.ui.book_categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewyork.data.repository.BooksRepository
import com.example.testnewyork.data.room.BooksCategoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val booksRepository: BooksRepository) :
    ViewModel() {

    private val _categoriesLiveData = MutableLiveData<List<BooksCategoryEntity>>()
    val categoriesLiveData: LiveData<List<BooksCategoryEntity>>
        get() = _categoriesLiveData


    fun getBooksCategories() {
        viewModelScope.launch {
            try {
                val categories = booksRepository.getBookCategories()
                _categoriesLiveData.value = categories

            } catch (e: Exception) {
                e.printStackTrace()
                _categoriesLiveData.value = booksRepository.loadBooksCategories()
            }
        }
    }
}