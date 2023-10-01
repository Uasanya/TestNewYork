package com.example.testnewyork.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class BooksResponse(

    @SerializedName("results")
    val results: BookCategory
)

@Parcelize
data class BookCategory(

    @SerializedName("list_name")
    val listName: String,

    @SerializedName("books")
    val books: List<Book>,
) : Parcelable

@Parcelize
data class Book(

    @SerializedName("amazon_product_url")
    val url: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("book_image")
    val imageUrl: String
) : Parcelable
