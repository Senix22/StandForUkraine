package com.example.standforukraine.data

import com.example.standforukraine.data.api.NewsApi
import com.example.standforukraine.domain.NewsDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository constructor(
    private val api: NewsApi,
    private val newsMapper: NewsResponseMapper
) {
    suspend fun requestNews(): Flow<List<NewsDomainModel>> =
        flow {
            emit(newsMapper.mapResponse(api.getNews()))
        }
}