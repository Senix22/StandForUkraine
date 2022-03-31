package com.example.standforukraine.domain

data class NewsDomainModel(
    val id: Long?,
    val date: Long?,
    val text: String?,
    val medias: List<NewsDomainMediaType>?
)

data class NewsDomainMediaType(
    val mediaId: Long?,
    val mediaType: String?,
    val mediaUrl: String?
)