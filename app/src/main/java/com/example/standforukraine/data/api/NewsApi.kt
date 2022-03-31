package com.example.standforukraine.data.api

import retrofit2.http.GET

interface NewsApi {

    @GET("api/rest/messages?limit=3&offset=3")
    suspend fun getNews() : NewsResponse
}