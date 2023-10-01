package com.example.testnewyork.di

import android.content.Context
import androidx.room.Room
import com.example.testnewyork.data.room.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDB(
        @ApplicationContext
        context: Context
    ): DataBase = Room.databaseBuilder(
        context,
        DataBase::class.java,
        "db"
    ).build()


    @Singleton
    @Provides
    fun provideDao(dataBase: DataBase) = dataBase.getDao()

}