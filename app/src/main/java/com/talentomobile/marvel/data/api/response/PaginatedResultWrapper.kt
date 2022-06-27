package com.talentomobile.marvel.data.api.response

data class PaginatedResultWrapper<T, I>(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val attributionText: String?,
    val attributionHTML: String?,
    val data: PaginatedResult<I>?,
    val etag: String?
)
