package com.example.standforukraine.data.api

import retrofit2.http.GET

interface NewsApi {

    @GET("api/rest/messages?limit=50&offset=0")
    suspend fun getNews() : NewsResponse
}