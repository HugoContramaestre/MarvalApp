package com.talentomobile.marvel.data.api.response

data class PaginatedResult<T>(
    val items: List<T>,
    val total: Int,
    val page: Int,
    val size: Int
)
