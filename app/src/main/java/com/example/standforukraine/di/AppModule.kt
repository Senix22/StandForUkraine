package com.example.standforukraine.di

import android.content.Context
import com.example.standforukraine.data.NewsRepository
import com.example.standforukraine.data.NewsResponseMapper
import com.example.standforukraine.data.api.NewsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    fun provideContext() = appContext

    @Singleton
    @Provides
    fun provideNewsRepository(newsApi: NewsApi, mapper: NewsResponseMapper): NewsRepository {
        return NewsRepository(newsApi, mapper)
    }
}