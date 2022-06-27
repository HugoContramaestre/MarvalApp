package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.Comics as ComicsDomain


data class Comics(

    @SerializedName("available") var available: String? = null,
    @SerializedName("returned") var returned: String? = null,
    @SerializedName("collectionURI") var collectionURI: String? = null,
    @SerializedName("items") var items: List<StorySummary> = emptyList()

) {
    fun toDomain() = ComicsDomain(
        available,
        returned,
        collectionURI,
        items.map { it.toDomain() }
    )
}