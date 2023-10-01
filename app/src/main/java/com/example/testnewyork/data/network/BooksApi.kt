package com.example.testnewyork.data.network

import com.example.testnewyork.data.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {

    @GET("svc/books/v3/lists/current/{list}.json")
    suspend fun getBooks(
        @Path("list") list: String,
        @Query("api-key") apiKey: String = "UyTD0IQiJjeZxGyzhxJ5k5S4Ydz73mGo"
    ): BooksResponse
}