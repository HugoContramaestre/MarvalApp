package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.characters.ComicSummary as ComicSummaryDomain

data class ComicSummary(
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("name") var name: String? = null,
) {
    fun toDomain() = ComicSummaryDomain(
        resourceUri,
        name
    )
}
