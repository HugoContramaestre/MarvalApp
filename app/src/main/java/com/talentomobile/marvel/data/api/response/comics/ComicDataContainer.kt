package com.talentomobile.marvel.data.api.response.comics

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.comics.ComicDataContainer as ComicDataContainerDomain
import com.talentomobile.marvel.data.api.response.Comic

data class ComicDataContainer(
    @SerializedName("offset") var offset: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("results") var results: List<Comic> = emptyList(),
) {
    fun toDomain() = ComicDataContainerDomain(
        offset,
        limit,
        total,
        count,
        results.map { it.toDomain() }.filter { it.id != -1 }
    )
}