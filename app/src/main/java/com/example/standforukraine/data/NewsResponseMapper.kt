package com.example.standforukraine.data

import com.example.standforukraine.data.api.NewsResponse
import com.example.standforukraine.domain.NewsDomainMediaType
import com.example.standforukraine.domain.NewsDomainModel
import javax.inject.Inject

class NewsResponseMapper @Inject constructor() {
//    fun mapResponse(newsResponse: NewsResponse): List<NewsDomainModel> {
//        return newsResponse.articles?.map { newsItem ->
//            NewsDomainModel(
//                author = newsItem.author.orEmpty(),
//                title = newsItem.title.orEmpty(),
//                description = newsItem.description.orEmpty(),
//                url = newsItem.url.orEmpty(),
//                urlToImage = newsItem.urlToImage.orEmpty(),
//                publishedAt = newsItem.publishedAt.orEmpty()
//            )
//        } ?: emptyList()
//    }

    fun mapResponse(newsResponse: NewsResponse): List<NewsDomainModel> {
        return newsResponse.message?.map { newsItem ->
            NewsDomainModel(
                id = newsItem.id,
                date = newsItem.date,
                text = newsItem.text,
                medias = newsItem.medias?.map {
                    NewsDomainMediaType(
                        mediaId = it.mediaId,
                        mediaType = it.mediaType,
                        mediaUrl = it.mediaUrl
                    )
                }
            )
        } ?: emptyList()
    }
}