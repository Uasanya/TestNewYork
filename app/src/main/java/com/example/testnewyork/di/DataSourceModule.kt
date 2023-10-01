package com.example.testnewyork.di

import com.example.testnewyork.data.datasource.BooksLocalDataSource
import com.example.testnewyork.data.datasource.BooksRemoteDataSource
import com.example.testnewyork.data.network.BooksApi
import com.example.testnewyork.data.room.Dao
import com.example.testnewyork.data.room.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideBooksRemoteDataSource(booksApi: BooksApi) = BooksRemoteDataSource(booksApi)

    @Singleton
    @Provides
    fun provideBooksLocalDataSource(dao: Dao) = BooksLocalDataSource(dao)
}