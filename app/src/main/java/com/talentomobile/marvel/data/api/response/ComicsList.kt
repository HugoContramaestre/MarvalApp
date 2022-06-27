package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.characters.ComicsList as ComicsListDomain

data class ComicsList(
    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionUri: String? = null,
    @SerializedName("items") var items: List<ComicSummary>? = emptyList(),
) {
    fun toDomain() = ComicsListDomain(
        available,
        returned,
        collectionUri,
        items?.map { it.toDomain() }
    )
}
