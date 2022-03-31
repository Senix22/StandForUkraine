package com.example.standforukraine.data.api

import com.google.gson.annotations.SerializedName

data class NewsResponse(@SerializedName("message") val message: List<NewsDto>?)

data class NewsDto(
    @SerializedName("id") val id: Long?,
    @SerializedName("date") val date: Long?,
    @SerializedName("text") val text: String?,
    @SerializedName("media") val medias: List<MediaType>?
) : NewsEventResponse()

data class MediaType(
    @SerializedName("id") val mediaId: Long?,
    @SerializedName("type") val mediaType: String?,
    @SerializedName("url") val mediaUrl: String?
)

sealed class NewsEventResponse