package com.example.standforukraine.data.api

import retrofit2.http.GET

interface NewsApi {

    //    @GET("/v2/top-headlines?sources=bbc-news&apiKey=435149dee83241479ddd0c3c8672cef9")
    @GET("api/rest/messages?limit=3&offset=3")
    suspend fun getNews() : NewsResponse
}