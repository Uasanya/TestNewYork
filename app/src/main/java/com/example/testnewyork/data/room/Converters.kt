package com.example.testnewyork.data.room

import androidx.room.TypeConverter
import com.example.testnewyork.data.model.Book
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<Book>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Book>::class.java).toList()
}
