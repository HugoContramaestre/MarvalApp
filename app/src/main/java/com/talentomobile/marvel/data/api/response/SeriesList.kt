package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.domain.common.SeriesList as SeriesListDomain

data class SeriesList(
    @SerializedName("available") var available: Int? = null,
    @SerializedName("returned") var returned: Int? = null,
    @SerializedName("collectionURI") var collectionUri: String? = null,
    @SerializedName("items") var items: List<SeriesSummary> = emptyList()

) {
    fun toDomain() = SeriesListDomain(
        available,
        returned,
        collectionUri,
        items.map { it.toDomain() }
    )
}
