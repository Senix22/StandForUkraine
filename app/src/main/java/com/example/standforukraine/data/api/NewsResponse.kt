package com.example.standforukraine.data.api

import com.google.gson.annotations.SerializedName

data class NewsResponse(@SerializedName("message") val message: List<NewsDto>?)

//data class NewsDto(
//    @SerializedName("sources") val sources: String?,
//    @SerializedName("author") val author: String?,
//    @SerializedName("title") val title: String?,
//    @SerializedName("description") val description: String?,
//    @SerializedName("url") val url: String?,
//    @SerializedName("urlToImage") val urlToImage: String?,
//    @SerializedName("publishedAt") val publishedAt: String?
//) : NewsEventResponse()
data class NewsDto(
    @SerializedName("id") val id: Long?,
    @SerializedName("date") val date: Long?,
    @SerializedName("text") val text: String?,
    @SerializedName("media") val medias: List<MediaType>?
) : NewsEventResponse()
//
//data class Nodes(
//    @SerializedName("nodes") val nodes: List<MediaType>?
//)

data class MediaType(
    @SerializedName("id") val mediaId: Long?,
    @SerializedName("type") val mediaType: String?,
    @SerializedName("url") val mediaUrl: String?
)

sealed class NewsEventResponse