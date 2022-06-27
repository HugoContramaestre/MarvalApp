package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.StoryList as StoryListDomain


data class StoryList(

    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionUri: String? = null,
    @SerializedName("items") var items: List<StorySummary> = emptyList()

) {
    fun toDomain() = StoryListDomain(
        available,
        returned,
        collectionUri,
        items.map { it.toDomain() }
    )
}