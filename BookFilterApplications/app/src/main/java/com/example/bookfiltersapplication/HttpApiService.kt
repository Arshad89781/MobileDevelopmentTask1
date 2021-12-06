package com.example.bookfiltersapplication

import retrofit2.http.GET

interface HttpApiService {
    @GET("/books")
    suspend fun getMyData():ArrayList<MyData>
}