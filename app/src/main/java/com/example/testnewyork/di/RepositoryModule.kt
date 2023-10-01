package com.example.testnewyork.di

import com.example.testnewyork.data.datasource.BooksLocalDataSource
import com.example.testnewyork.data.datasource.BooksRemoteDataSource
import com.example.testnewyork.data.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBooksRepository(
        booksRemoteDataSource: BooksRemoteDataSource,
        booksLocalDataSource: BooksLocalDataSource
    ) =
        BooksRepository(booksRemoteDataSource, booksLocalDataSource)
}